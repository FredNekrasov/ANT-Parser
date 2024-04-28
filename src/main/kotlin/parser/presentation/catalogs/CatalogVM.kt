package parser.presentation.catalogs

import parser.domain.interactors.catalogs.CatalogInteractors
import parser.domain.models.Catalog
import parser.domain.utils.ActionStatus
import javax.inject.Inject

class CatalogVM @Inject constructor(
    private val interactor: CatalogInteractors
) {
    fun insertCatalog(catalogName: String): ActionStatus {
        if (catalogName.isBlank()) return ActionStatus.FAILURE
        return interactor.insertCatalog(Catalog(name = catalogName))
    }
    fun deleteCatalog(id: Int): ActionStatus = interactor.deleteCatalog(id)
    fun getAllCatalogs(): List<Catalog> = interactor.getCatalogs()
}