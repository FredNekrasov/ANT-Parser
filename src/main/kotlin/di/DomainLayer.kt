package di

import di.domainLayer.*
import org.koin.dsl.module

val domainLayer = module {
    includes(catalogModule, articleModule, contentModule)
}