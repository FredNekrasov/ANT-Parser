package parser.domain.interactors.articles.insert

import parser.domain.models.Article
import parser.domain.repositories.IRepository
import javax.inject.Inject

class InsertArticleInteractor @Inject constructor(
    private val repository: IRepository<Article, Long>
) {
    operator fun invoke(model: Article) = repository.insert(model)
}