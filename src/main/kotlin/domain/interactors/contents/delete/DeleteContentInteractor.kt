package domain.interactors.contents.delete

import domain.models.Content
import domain.repositories.IRepository
import domain.utils.ActionStatus

class DeleteContentInteractor(
    private val repository: IRepository<Content, Long>
) {
    operator fun invoke(id: Long): ActionStatus {
        if (id <= 0) return ActionStatus.FAILURE
        repository.getList().firstOrNull { it.id == id } ?: return ActionStatus.NOT_FOUND
        repository.delete(id)
        return ActionStatus.SUCCESS
    }
}