package domain.interactors.articles

import domain.interactors.articles.delete.DeleteArticleInteractor
import domain.interactors.articles.get.GetArticlesInteractor
import domain.interactors.articles.insert.InsertArticleInteractor

data class ArticleInteractors(
    val get: GetArticlesInteractor,
    val delete: DeleteArticleInteractor,
    val insert: InsertArticleInteractor
)