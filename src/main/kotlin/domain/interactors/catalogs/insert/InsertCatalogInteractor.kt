package domain.interactors.catalogs.insert

import domain.models.Catalog
import domain.repositories.IRepository
import domain.utils.ActionStatus

class InsertCatalogInteractor(
    private val repository: IRepository<Catalog, Int>
) {
    suspend operator fun invoke(catalogName: String): ActionStatus {
        if (catalogName.isBlank()) return ActionStatus.FAILURE
        val catalog = repository.getList().firstOrNull { it.name.lowercase() == catalogName.lowercase() }
        if (catalog != null) return ActionStatus.ALREADY_EXISTS
        repository.insert(Catalog(name = catalogName))
        return ActionStatus.SUCCESS
    }
}