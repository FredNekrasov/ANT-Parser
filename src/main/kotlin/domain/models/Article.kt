package domain.models

data class Article(
    val id: Long = 0L,
    val catalog: Catalog,
    val title: String,
    val description: String,
    val dateOrBanner: String
)