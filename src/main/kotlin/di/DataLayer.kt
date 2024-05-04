package di

import data.remote.WebAPI
import data.repositories.*
import domain.models.*
import domain.repositories.IRepository
import org.koin.dsl.module

val dataLayer = module {
    single<WebAPI>(createdAtStart = true) {
        WebAPI()
    }
    single<IRepository<Catalog, Int>> { 
        CatalogRepository(get<WebAPI>())
    }
    single<IRepository<Article, Long>> {
        ArticleRepository(get<WebAPI>())
    }
    single<IRepository<Content, Long>> {
        ContentRepository(get<WebAPI>())
    }
}