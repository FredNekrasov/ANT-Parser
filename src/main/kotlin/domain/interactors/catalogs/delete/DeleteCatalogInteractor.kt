package domain.interactors.catalogs.delete

import domain.models.Catalog
import domain.repositories.IRepository
import domain.utils.ActionStatus

class DeleteCatalogInteractor(
    private val repository: IRepository<Catalog, Int>
) {
    operator fun invoke(id: Int): ActionStatus {
        if (id <= 0) return ActionStatus.FAILURE
        repository.getList().firstOrNull { it.id == id } ?: return ActionStatus.NOT_FOUND
        repository.delete(id)
        return ActionStatus.SUCCESS
    }
}