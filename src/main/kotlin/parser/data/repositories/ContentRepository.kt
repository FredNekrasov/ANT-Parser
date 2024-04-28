package parser.data.repositories

import io.ktor.client.request.*
import kotlinx.coroutines.*
import parser.data.remote.WebAPI
import parser.domain.models.Content
import parser.domain.repositories.IRepository

class ContentRepository(
    private val api: WebAPI
) : IRepository<Content, Long> {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val url = "https://alexander-nevsky.ru/content/"
    private var list = emptyList<Content>()
    override fun getList(): List<Content> {
        scope.launch {
            api.getHttpClient().get(url) {
            }
        }
        return list
    }
    override fun insert(model: Content) {
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