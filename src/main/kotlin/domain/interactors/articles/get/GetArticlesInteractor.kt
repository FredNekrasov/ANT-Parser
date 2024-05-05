package domain.interactors.articles.get

import domain.models.Article
import domain.repositories.IRepository

class GetArticlesInteractor(
    private val repository: IRepository<Article, Long>
) {
    suspend operator fun invoke(): List<Article> = repository.getList()
}