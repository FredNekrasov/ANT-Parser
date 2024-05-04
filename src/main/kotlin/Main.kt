import di.*
import org.koin.core.context.startKoin
import parser.catalogs.CatalogParser

fun main() {
    val app = startKoin {
        printLogger()
        modules(dataLayer, domainLayer, presentationLayer)
    }
    app.koin.get<CatalogParser>().parseCatalogs().joinToString("\n") { it.trim() }.let { println(it) }
}
// information https://hramalnevskogo.ru/page42533272.html
// spirit talk https://hramalnevskogo.ru/page40967215.html
