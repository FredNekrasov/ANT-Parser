import di.*
import kotlinx.coroutines.*
import org.koin.core.context.startKoin

fun main(): Unit = runBlocking {
    val scope = CoroutineScope(Dispatchers.IO)
    startKoin {
        modules(dataLayer, domainLayer, presentationLayer)
    }.apply {
        scope.launch {
        }.join()
    }
}
// information https://hramalnevskogo.ru/page42533272.html
// spirit talk https://hramalnevskogo.ru/page40967215.html
/*
fun getUrls(url: String = "listOfURLs", clazzName: String = "t-feed__textwrapper", attribute: String = "href"): String = Jsoup.parse(url)
    .getElementsByClass(clazzName)
    .joinToString("\n") {
        it.getElementsByTag("a").attr(attribute)
    }
suspend fun insertDynamicArticles(
    list: List<String>,
    parser: DATParser,
    catalog: Catalog,
    interactors: ArticleInteractors
) {
    list.forEachIndexed { index, it ->
        val title = parser.parseTitle(url = it)
        val description = parser.parseDescription(url = it)
        val date = parser.parseDate(url = it)
        val article = Article(catalog = catalog, title = title, description = description, dateOrBanner = date)
        interactors.insert(article)
        println(index)
    }
}
suspend fun insertDynamicContents(
    startArticleId: Long,
    list: List<String>,
    parser: DATParser,
    interactors: ContentInteractors
) {
    var articleId = startArticleId
    list.forEachIndexed { index, it ->
        println(index)
        parser.parseContent(it).split("\n").forEach { image ->
            val content = Content(articleId = articleId, data = image)
            if (image.isNotBlank()) interactors.insert(content)
        }
        articleId++
    }
}
suspend fun insertCatalogs(
    catalogParser: CatalogParser,
    catalogInteractors: CatalogInteractors
) {
    catalogParser.parseCatalogs().forEach {
        when(catalogInteractors.insert(it)) {
            ActionStatus.SUCCESS -> println("$it inserted successfully")
            ActionStatus.FAILURE -> println("$it failed to insert")
            else -> println("$it already exists")
        }
    }
    catalogInteractors.get().forEach(::println)
}*/
