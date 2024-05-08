package presentation.parser.articleTypes

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class ContactParser {
    private fun parseData(
        contactPage: String = "https://hramalnevskogo.ru/page42046286.html"
    ): Document = Jsoup.connect(contactPage).get()
    fun parseTitle(clazzName: String = "t555__contentwrapper"): String = parseData()
        .getElementsByClass(clazzName)
        .html()
        .split("<[\\w>\\s=\"-:;!@]*".toRegex())
        .filter { it.isNotBlank() }
        .slice(0..1)
        .joinToString(" ") { it.trim() }
    fun parseContacts(
        clazzName: String = "t451__rightside t451__side t451__side_socials",
        tag: String = "a",
        attribute: String = "href"
    ): List<String> = parseData()
        .getElementsByClass(clazzName)
        .map {
            it.getElementsByTag(tag)
        }
        .flatten()
        .map {
            it.attr(attribute).trim()
        }
}