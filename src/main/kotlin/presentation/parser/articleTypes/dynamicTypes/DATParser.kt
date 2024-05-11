package presentation.parser.articleTypes.dynamicTypes

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

abstract class DATParser {// Dynamic articles type (DAT)
    protected fun parseData(url: String): Document = Jsoup.connect(url).get()
    fun parseTitle(
        url: String,
        clazzName: String = "t-feed__post-popup__title-wrapper"
    ): String = parseData(url).getElementsByClass(clazzName).text()
    open fun parseContent(
        url: String,
        clazzName: String = "t_feed__post-popup__gallery-imgwrapper",
        attribute: String = "data-original"
    ): String = parseData(url)
        .getElementsByClass(clazzName)
        .joinToString("\n") {
            it.children().attr(attribute).trim()
        }
    fun parseDate(
        url: String,
        clazzName: String = "t-feed__post-popup__date-wrapper"
    ): String = parseData(url).getElementsByClass(clazzName).text()
    open fun parseDescription(
        url: String,
        clazzName: String = "t-redactor__text"
    ): String = parseData(url).getElementsByClass(clazzName).text()
}