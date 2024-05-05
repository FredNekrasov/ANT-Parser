package data.mappers

import data.remote.dto.CatalogDto
import domain.models.Catalog

fun Catalog.toDto() = CatalogDto(
    id, name
)
fun CatalogDto.toDomain() = Catalog(
    id, name
)