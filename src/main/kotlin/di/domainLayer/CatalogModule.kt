package di.domainLayer

import di.utils.DIStrings
import domain.interactors.catalogs.CatalogInteractors
import domain.interactors.catalogs.delete.DeleteCatalogInteractor
import domain.interactors.catalogs.get.GetCatalogsInteractor
import domain.interactors.catalogs.insert.InsertCatalogInteractor
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val catalogModule = module {
    single {
        InsertCatalogInteractor(get(qualifier(DIStrings.CATALOG_REPOSITORY)))
    }
    single {
        DeleteCatalogInteractor(get(qualifier(DIStrings.CATALOG_REPOSITORY)))
    }
    single {
        GetCatalogsInteractor(get(qualifier(DIStrings.CATALOG_REPOSITORY)))
    }
    single(qualifier(DIStrings.CATALOG_INTERACTORS)) {
        CatalogInteractors(
            get<GetCatalogsInteractor>(),
            get<DeleteCatalogInteractor>(),
            get<InsertCatalogInteractor>()
        )
    }
}