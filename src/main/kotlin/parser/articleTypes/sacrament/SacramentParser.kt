package parser.articleTypes.sacrament

import org.jsoup.Jsoup

class SacramentParser {
    private fun parseData(
        sacramentPage: String = "https://hramalnevskogo.ru/page41138104.html",
        clazzName: String = "t001__wrapper"
    ): List<String> = Jsoup.connect(sacramentPage)
        .get()
        .getElementsByClass(clazzName)
        .html()
        .split("<[\\w>\\s=\"-:;]*".toRegex())
        .dropLastWhile { it.isBlank() }
        .joinToString("\n") { it.trim() }
        .split("\\s\\s+".toRegex())
    fun parseTitle(): String = parseData()
        .slice(0..1)
        .joinToString("\n")
    fun parseDescription(): String = parseData()
        .run {
            slice(2..lastIndex)
                .joinToString("\n") {
                    it.replace("&nbsp;&nbsp;", "")
                }
        }
}