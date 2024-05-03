package parser.domain.interactors.articles.delete

import parser.domain.models.Article
import parser.domain.repositories.IRepository
import parser.domain.utils.ActionStatus
import javax.inject.Inject

class DeleteArticleInteractor @Inject constructor(
    private val repository: IRepository<Article, Long>
) {
    operator fun invoke(id: Long): ActionStatus {
        if (id <= 0) return ActionStatus.FAILURE
        repository.getList().firstOrNull { it.id == id } ?: return ActionStatus.NOT_FOUND
        repository.delete(id)
        return ActionStatus.SUCCESS
    }
}