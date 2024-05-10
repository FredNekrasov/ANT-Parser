package di

import data.repositories.*
import domain.models.*
import domain.repositories.IRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataLayer = module {
    single(createdAtStart = true) {
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
    single<IRepository<Catalog, Int>> {
        CatalogRepository(get<HttpClient>())
    }
    single<IRepository<Article, Long>> {
        ArticleRepository(get<HttpClient>())
    }
    single<IRepository<Content, Long>> {
        ContentRepository(get<HttpClient>())
    }
}