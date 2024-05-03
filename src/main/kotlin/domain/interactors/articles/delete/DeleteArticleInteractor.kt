package domain.interactors.articles.delete

import domain.models.Article
import domain.repositories.IRepository
import domain.utils.ActionStatus

class DeleteArticleInteractor(
    private val repository: IRepository<Article, Long>
) {
    operator fun invoke(id: Long): ActionStatus {
        if (id <= 0) return ActionStatus.FAILURE
        repository.getList().firstOrNull { it.id == id } ?: return ActionStatus.NOT_FOUND
        repository.delete(id)
        return ActionStatus.SUCCESS
    }
}