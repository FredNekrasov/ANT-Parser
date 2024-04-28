package parser.domain.interactors.catalogs.insert

import parser.domain.models.Catalog
import parser.domain.repositories.IRepository
import parser.domain.utils.ActionStatus
import javax.inject.Inject

class InsertCatalogInteractor @Inject constructor(
    private val repository: IRepository<Catalog, Int>
) {
    operator fun invoke(model: Catalog): ActionStatus {
        val catalog = repository.getList().firstOrNull { it.name.lowercase() == model.name.lowercase() }
        if (catalog != null) return ActionStatus.NOT_FOUND
        repository.insert(model)
        return ActionStatus.SUCCESS
    }
}