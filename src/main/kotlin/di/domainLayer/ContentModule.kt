package di.domainLayer

import domain.interactors.contents.ContentInteractors
import domain.interactors.contents.delete.DeleteContentInteractor
import domain.interactors.contents.get.GetContentsInteractor
import domain.interactors.contents.insert.InsertContentInteractor
import domain.models.Content
import domain.repositories.IRepository
import org.koin.dsl.module

val contentModule = module {
    factory {
        InsertContentInteractor(get<IRepository<Content, Long>>())
    }
    factory {
        DeleteContentInteractor(get<IRepository<Content, Long>>())
    }
    factory {
        GetContentsInteractor(get<IRepository<Content, Long>>())
    }
    factory {
        ContentInteractors(
            get<GetContentsInteractor>(),
            get<DeleteContentInteractor>(),
            get<InsertContentInteractor>()
        )
    }
}