package di.domainLayer

import di.utils.DIStrings
import domain.interactors.articles.ArticleInteractors
import domain.interactors.articles.delete.DeleteArticleInteractor
import domain.interactors.articles.get.GetArticlesInteractor
import domain.interactors.articles.insert.InsertArticleInteractor
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val articleModule = module {
    single {
        InsertArticleInteractor(get(qualifier(DIStrings.ARTICLE_REPOSITORY)))
    }
    single {
        DeleteArticleInteractor(get(qualifier(DIStrings.ARTICLE_REPOSITORY)))
    }
    single {
        GetArticlesInteractor(get(qualifier(DIStrings.ARTICLE_REPOSITORY)))
    }
    single(qualifier(DIStrings.ARTICLE_INTERACTORS)) {
        ArticleInteractors(
            get<GetArticlesInteractor>(),
            get<DeleteArticleInteractor>(),
            get<InsertArticleInteractor>()
        )
    }
}