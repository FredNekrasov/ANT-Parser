package domain.interactors.catalogs

import domain.interactors.catalogs.delete.DeleteCatalogInteractor
import domain.interactors.catalogs.get.GetCatalogsInteractor
import domain.interactors.catalogs.insert.InsertCatalogInteractor

data class CatalogInteractors(
    val get: GetCatalogsInteractor,
    val delete: DeleteCatalogInteractor,
    val insert: InsertCatalogInteractor
)