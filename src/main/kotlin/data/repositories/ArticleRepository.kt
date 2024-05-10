package data.repositories

import data.mappers.*
import data.remote.dto.ArticleDto
import domain.models.Article
import domain.repositories.IRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ArticleRepository(
    private val client: HttpClient
) : IRepository<Article, Long> {
    private val url = "http://localhost:5115/api/v2/article"
    override suspend fun getList(): List<Article> = client.get(url)
        .body<List<ArticleDto>>()
        .map {
            it.toDomain()
        }
    override suspend fun insert(model: Article) = client.post(url) {
        contentType(ContentType.Application.Json)
        setBody(model.toDto())
    }.let { 
        println(it.status.description)
    }
    override suspend fun delete(id: Long) = println(client.delete("$url/$id").status.description)
}