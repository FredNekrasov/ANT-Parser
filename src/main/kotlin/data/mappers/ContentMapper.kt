package data.mappers

import data.remote.dto.ContentDto
import domain.models.Content

fun Content.toDto() = ContentDto(
    id, articleId, data
)
fun ContentDto.toDomain() = Content(
    id, articleId, data
)