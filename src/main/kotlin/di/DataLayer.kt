package di

import data.repositories.*
import di.utils.DIStrings
import domain.models.*
import domain.repositories.IRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val dataLayer = module {
    single(qualifier(DIStrings.HTTP_CLIENT), createdAtStart = true) {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }
        }
    }
    single<IRepository<Catalog, Int>>(qualifier(DIStrings.CATALOG_REPOSITORY), createdAtStart = true) {
        CatalogRepository(get(qualifier(DIStrings.HTTP_CLIENT)))
    }
    single<IRepository<Article, Long>>(qualifier(DIStrings.ARTICLE_REPOSITORY), createdAtStart = true) {
        ArticleRepository(get(qualifier(DIStrings.HTTP_CLIENT)))
    }
    single<IRepository<Content, Long>>(qualifier(DIStrings.CONTENT_REPOSITORY), createdAtStart = true) {
        ContentRepository(get(qualifier(DIStrings.HTTP_CLIENT)))
    }
}