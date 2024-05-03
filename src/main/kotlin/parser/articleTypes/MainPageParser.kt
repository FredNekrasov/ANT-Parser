package parser.articleTypes

import org.jsoup.Jsoup
import org.jsoup.select.Elements

class MainPageParser {
    private val mainPage: String = "https://hramalnevskogo.ru/"
    private val clazzName: String = "tn-atom"
    private fun parseData(): Elements = Jsoup.connect(mainPage)
        .get()
        .getElementsByClass(clazzName)
    fun parseBanner(): String = parseData()
        .map {
            it.wholeOwnText()
                .replace("\\s\\s+".toRegex(), "")
                .trim()
        }
        .slice(0..1)
        .joinToString("")
        .split("\n")
        .joinToString(" ")
    private fun parseText(): List<String> = parseData()
        .html()
        .replace("</?\\w*>".toRegex(), "\n")
        .replace("\\s\\s+".toRegex(), "\n")
        .split("\n".toRegex())
    fun parseTitle(): String = parseText()
        .slice(8..8)
        .joinToString("")
    fun parseDescription(): String = parseText()
        .run {
            slice(9..lastIndex)
                .joinToString("\n")
        }
}