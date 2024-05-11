package presentation.parser.articleTypes.staticTypes

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class VolunteerismParser {
    private val clazzName = "t-container"
    private fun parseData(
        volunteerismPage: String = "https://hramalnevskogo.ru/page45347187.html"
    ): Document = Jsoup.connect(volunteerismPage).get()
    private fun parseText(): List<String> = parseData()
        .getElementsByClass(clazzName)
        .map { it.children().html() }
        .slice(0..1)[0]
        .split("^[<\\w\\s=\"-:>;]*".toRegex())
        .joinToString("\n") { it.trim() }
        .split("<[\\w>\\s=\"-:;]*".toRegex())
        .filter { it.isNotBlank() }
    fun parseTitle(): String = parseText()[0].trim()
    fun parseDescription(): String = parseText()
        .map { it.trim() }
        .drop(1)
        .joinToString("\n")
    fun parseContent(
        clazzName: String = "t156__wrapper",
        subClazzName: String = "t156__item",
        attribute: String = "data-original"
    ): List<String> = parseData()
        .getElementsByClass(clazzName)
        .map { it.getElementsByClass(subClazzName) }
        .flatten()
        .map {
            it.children().attr(attribute)
        }
}