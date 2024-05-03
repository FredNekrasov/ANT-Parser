package parser.domain.interactors.catalogs.get

import parser.domain.models.Catalog
import parser.domain.repositories.IRepository
import javax.inject.Inject

class GetCatalogsInteractor @Inject constructor(
    private val repository: IRepository<Catalog, Int>
) {
    operator fun invoke(): List<Catalog> = repository.getList()
}