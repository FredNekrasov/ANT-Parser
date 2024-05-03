package parser.di

import dagger.*
import parser.data.remote.WebAPI
import parser.data.repositories.*
import parser.domain.models.*
import parser.domain.repositories.IRepository
import javax.inject.Singleton

@Module
object DataModule {
    @Singleton
	@Provides
    fun provideAPI(): WebAPI = WebAPI()
    @Singleton
	@Provides
    fun provideCatalogRepository(api: WebAPI): IRepository<Catalog, Int> = CatalogRepository(api)
    @Singleton
	@Provides
    fun provideArticleRepository(api: WebAPI): IRepository<Article, Long> = ArticleRepository(api)
    @Singleton
	@Provides
    fun provideContentRepository(api: WebAPI): IRepository<Content, Long> = ContentRepository(api)
}