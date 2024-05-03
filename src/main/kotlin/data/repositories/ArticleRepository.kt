package parser.data.repositories

import io.ktor.client.request.*
import kotlinx.coroutines.*
import parser.data.remote.WebAPI
import parser.domain.models.Article
import parser.domain.repositories.IRepository

class ArticleRepository(
    private val api: WebAPI
) : IRepository<Article, Long> {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val url = "https://alexander-nevsky.ru/article/"
    private var list = emptyList<Article>()
    override fun getList(): List<Article> {
        TODO("Not yet implemented")
    }
    override fun insert(model: Article) {
        scope.launch { 
            api.getHttpClient().post(url)
        }
    }
    override fun delete(id: Long) {
        scope.launch {
            api.getHttpClient().delete(url)
        }
    }
}