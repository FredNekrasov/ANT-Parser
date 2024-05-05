package domain.interactors.catalogs.get

import domain.models.Catalog
import domain.repositories.IRepository

class GetCatalogsInteractor(
    private val repository: IRepository<Catalog, Int>
) {
    suspend operator fun invoke(): List<Catalog> = repository.getList()
}