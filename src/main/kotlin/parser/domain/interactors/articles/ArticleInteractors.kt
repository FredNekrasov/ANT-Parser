package parser.domain.interactors.articles

import parser.domain.interactors.articles.delete.DeleteArticleInteractor
import parser.domain.interactors.articles.get.GetArticlesInteractor
import parser.domain.interactors.articles.insert.InsertArticleInteractor

data class ArticleInteractors(
    val getArticles: GetArticlesInteractor,
    val deleteArticle: DeleteArticleInteractor,
    val insertArticle: InsertArticleInteractor
)