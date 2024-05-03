package parser.di.menu

import parser.domain.interactors.articles.ArticleInteractors
import parser.domain.interactors.catalogs.CatalogInteractors
import parser.domain.interactors.contents.ContentInteractors
import javax.inject.Inject

class MenuBuilder @Inject constructor(
    private val catalogInteractors: CatalogInteractors,
    private val articleInteractors: ArticleInteractors,
    private val contentInteractors: ContentInteractors
) {
    fun getCatalogs(): CatalogInteractors = catalogInteractors
    fun getArticles(): ArticleInteractors = articleInteractors
    fun getContents(): ContentInteractors = contentInteractors
}