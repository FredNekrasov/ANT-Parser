package parser.domain.interactors.catalogs.insert

import parser.domain.models.Catalog
import parser.domain.repositories.IRepository
import parser.domain.utils.ActionStatus
import javax.inject.Inject

class InsertCatalogInteractor @Inject constructor(
    private val repository: IRepository<Catalog, Int>
) {
    operator fun invoke(catalogName: String): ActionStatus {
        if (catalogName.isBlank()) return ActionStatus.FAILURE
        val catalog = repository.getList().firstOrNull { it.name.lowercase() == catalogName.lowercase() }
        if (catalog != null) return ActionStatus.ALREADY_EXISTS
        repository.insert(Catalog(name = catalogName))
        return ActionStatus.SUCCESS
    }
}