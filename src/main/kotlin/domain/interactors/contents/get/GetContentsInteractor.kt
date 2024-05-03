package parser.domain.interactors.contents.get

import parser.domain.models.Content
import parser.domain.repositories.IRepository
import javax.inject.Inject

class GetContentsInteractor @Inject constructor(
    private val repository: IRepository<Content, Long>
) {
    operator fun invoke(): List<Content> = repository.getList()
}