package di.domainLayer

import di.utils.DIStrings
import domain.interactors.contents.ContentInteractors
import domain.interactors.contents.delete.DeleteContentInteractor
import domain.interactors.contents.get.GetContentsInteractor
import domain.interactors.contents.insert.InsertContentInteractor
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val contentModule = module {
    single {
        InsertContentInteractor(get(qualifier(DIStrings.CONTENT_REPOSITORY)))
    }
    single {
        DeleteContentInteractor(get(qualifier(DIStrings.CONTENT_REPOSITORY)))
    }
    single {
        GetContentsInteractor(get(qualifier(DIStrings.CONTENT_REPOSITORY)))
    }
    single(qualifier(DIStrings.CONTENT_INTERACTORS)) {
        ContentInteractors(
            get<GetContentsInteractor>(),
            get<DeleteContentInteractor>(),
            get<InsertContentInteractor>()
        )
    }
}