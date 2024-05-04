package di.domainLayer

import domain.interactors.catalogs.CatalogInteractors
import domain.interactors.catalogs.delete.DeleteCatalogInteractor
import domain.interactors.catalogs.get.GetCatalogsInteractor
import domain.interactors.catalogs.insert.InsertCatalogInteractor
import domain.models.Catalog
import domain.repositories.IRepository
import org.koin.dsl.module

val catalogModule = module {
    factory {
        InsertCatalogInteractor(get<IRepository<Catalog, Int>>())
    }
    factory {
        DeleteCatalogInteractor(get<IRepository<Catalog, Int>>())
    }
    factory {
        GetCatalogsInteractor(get<IRepository<Catalog, Int>>())
    }
    factory {
        CatalogInteractors(
            get<GetCatalogsInteractor>(),
            get<DeleteCatalogInteractor>(),
            get<InsertCatalogInteractor>()
        )
    }
}