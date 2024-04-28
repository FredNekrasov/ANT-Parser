package parser.domain.models

data class Content(
    val id: Long = 0L,
    val articleId: Long,
    val data: String//it can be contacts or images
)