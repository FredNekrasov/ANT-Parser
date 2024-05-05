package data.repositories

import data.mappers.*
import data.remote.dto.CatalogDto
import domain.models.Catalog
import domain.repositories.IRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class CatalogRepository(
    private val client: HttpClient
) : IRepository<Catalog, Int> {
    private val url = "http://localhost:5135/api/ArticleType"
    override suspend fun getList(): List<Catalog> = client.get(url)
        .body<List<CatalogDto>>()
        .map { 
            it.toDomain()
        }
    override suspend fun insert(model: Catalog) = client.post(url) {
        contentType(ContentType.Application.Json)
        setBody(model.toDto())
    }.let {
        println(it.status.description)
    }
    override suspend fun delete(id: Int) = println(client.delete("$url/$id").status.description)
}