package parser.domain.interactors.catalogs.delete

import parser.domain.models.Catalog
import parser.domain.repositories.IRepository
import parser.domain.utils.ActionStatus
import javax.inject.Inject

class DeleteCatalogInteractor @Inject constructor(
    private val repository: IRepository<Catalog, Int>
) {
    operator fun invoke(id: Int): ActionStatus {
        if (id <= 0) return ActionStatus.FAILURE
        repository.getList().firstOrNull { it.id == id } ?: return ActionStatus.NOT_FOUND
        repository.delete(id)
        return ActionStatus.SUCCESS
    }
}