package data.mappers

import data.remote.dto.ArticleDto
import domain.models.Article

fun Article.toDto() = ArticleDto(
    id, catalog.toDto(), title, description, dateOrBanner
)
fun ArticleDto.toDomain() = Article(
    id, catalog.toDomain(), title, description, dateOrBanner
)