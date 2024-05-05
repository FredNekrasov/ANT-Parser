package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import presentation.parser.catalogs.CatalogParser
import presentation.parser.articleTypes.*

val presentationLayer = module {
    factoryOf(::CatalogParser)
    factoryOf(::MainPageParser)
    factoryOf(::ContactParser)
    factoryOf(::PriesthoodParser)
    factoryOf(::SacramentParser)
    factoryOf(::ScheduleParser)
    factoryOf(::VolunteerismParser)
}