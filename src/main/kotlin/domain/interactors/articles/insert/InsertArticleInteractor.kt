package domain.interactors.articles.insert

import domain.models.Article
import domain.repositories.IRepository

class InsertArticleInteractor(
    private val repository: IRepository<Article, Long>
) {
    operator fun invoke(model: Article) = repository.insert(model)
}