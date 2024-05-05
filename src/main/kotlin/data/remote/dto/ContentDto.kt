package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ContentDto(
    val id: Long = 0L,
    val articleId: Long,
    val data: String
)