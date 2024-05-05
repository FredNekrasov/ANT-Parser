package data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatalogDto(
    val id: Int = 0,
    val name: String//it can be contacts or images
)