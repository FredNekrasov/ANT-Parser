package parser.domain.interactors.articles.get

import parser.domain.models.Article
import parser.domain.repositories.IRepository
import javax.inject.Inject

class GetArticlesInteractor @Inject constructor(
    private val repository: IRepository<Article, Long>
) {
    operator fun invoke(): List<Article> = repository.getList()
}