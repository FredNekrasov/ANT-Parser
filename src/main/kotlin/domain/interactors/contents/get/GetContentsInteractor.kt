package domain.interactors.contents.get

import domain.models.Content
import domain.repositories.IRepository

class GetContentsInteractor(
    private val repository: IRepository<Content, Long>
) {
    suspend operator fun invoke(): List<Content> = repository.getList()
}