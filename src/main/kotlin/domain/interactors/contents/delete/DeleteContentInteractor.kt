package parser.domain.interactors.contents.delete

import parser.domain.models.Content
import parser.domain.repositories.IRepository
import parser.domain.utils.ActionStatus
import javax.inject.Inject

class DeleteContentInteractor @Inject constructor(
    private val repository: IRepository<Content, Long>
) {
    operator fun invoke(id: Long): ActionStatus {
        if (id <= 0) return ActionStatus.FAILURE
        repository.getList().firstOrNull { it.id == id } ?: return ActionStatus.NOT_FOUND
        repository.delete(id)
        return ActionStatus.SUCCESS
    }
}