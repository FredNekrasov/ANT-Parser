package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    val id: Long = 0L,
    val catalog: CatalogDto,
    val title: String,
    val description: String,
    val dateOrBanner: String
)