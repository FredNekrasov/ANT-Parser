package di.domainLayer

import domain.interactors.articles.ArticleInteractors
import domain.interactors.articles.delete.DeleteArticleInteractor
import domain.interactors.articles.get.GetArticlesInteractor
import domain.interactors.articles.insert.InsertArticleInteractor
import domain.models.Article
import domain.repositories.IRepository
import org.koin.dsl.module

val articleModule = module {
    factory {
        InsertArticleInteractor(get<IRepository<Article, Long>>())
    }
    factory {
        DeleteArticleInteractor(get<IRepository<Article, Long>>())
    }
    factory {
        GetArticlesInteractor(get<IRepository<Article, Long>>())
    }
    factory {
        ArticleInteractors(
            get<GetArticlesInteractor>(),
            get<DeleteArticleInteractor>(),
            get<InsertArticleInteractor>()
        )
    }
}