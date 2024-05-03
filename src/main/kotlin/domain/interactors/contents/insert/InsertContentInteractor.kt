package parser.domain.interactors.contents.insert

import parser.domain.models.Content
import parser.domain.repositories.IRepository
import javax.inject.Inject

class InsertContentInteractor @Inject constructor(
    private val repository: IRepository<Content, Long>
) {
    operator fun invoke(model: Content) = repository.insert(model)
}