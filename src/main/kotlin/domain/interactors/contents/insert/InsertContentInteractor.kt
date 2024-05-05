package domain.interactors.contents.insert

import domain.models.Content
import domain.repositories.IRepository

class InsertContentInteractor(
    private val repository: IRepository<Content, Long>
) {
    suspend operator fun invoke(model: Content) = repository.insert(model)
}