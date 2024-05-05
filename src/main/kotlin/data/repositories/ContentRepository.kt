package data.repositories

import data.mappers.*
import data.remote.dto.ContentDto
import domain.models.Content
import domain.repositories.IRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ContentRepository(
    private val client: HttpClient
) : IRepository<Content, Long> {
    private val url = "http://localhost:5135/api/content" 
    override suspend fun getList(): List<Content> = client.get(url)
        .body<List<ContentDto>>()
        .map {
            it.toDomain()
        }
    override suspend fun insert(model: Content) = client.post(url) {
        contentType(ContentType.Application.Json)
        setBody(model.toDto())
    }.let {
        println(it.status.description)
    }
    override suspend fun delete(id: Long) = println(client.delete("$url/$id").status.description)
}