package presentation.parser.articleTypes.staticTypes

import org.jsoup.Jsoup
import org.jsoup.select.Elements

class PriesthoodParser {
    private fun parseData(
        priesthoodPage: String = "https://hramalnevskogo.ru/page40988065.html",
        clazzName: String = "tn-atom"
    ): Elements = Jsoup.connect(priesthoodPage).get().getElementsByClass(clazzName)
    fun parseDescription(): String = parseData()
        .joinToString("\n") { it.wholeOwnText().trim() }
        .split("\n")
        .joinToString("\n") { it.trim() }
    fun parseTitle(tag: String = "strong"): String = parseData()
        .joinToString("") {
            it.children().tagName(tag).html().trim()
        }
    fun parseContent(attribute: String = "data-original"): String = parseData()
        .joinToString("") {
            it.children().attr(attribute).trim()
        }
}