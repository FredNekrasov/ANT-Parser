package parser.domain.interactors.catalogs

import parser.domain.interactors.catalogs.delete.DeleteCatalogInteractor
import parser.domain.interactors.catalogs.get.GetCatalogsInteractor
import parser.domain.interactors.catalogs.insert.InsertCatalogInteractor

data class CatalogInteractors(
    val getCatalogs: GetCatalogsInteractor,
    val deleteCatalog: DeleteCatalogInteractor,
    val insertCatalog: InsertCatalogInteractor
)