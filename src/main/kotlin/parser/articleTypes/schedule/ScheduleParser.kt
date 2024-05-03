package parser.articleTypes.schedule

import org.jsoup.Jsoup

class ScheduleParser {
    private val schedulePage: String = "https://hramalnevskogo.ru/page40966859.html"
    private val attribute = "data-original"
    fun parseIf1Content(
        clazzName: String = "t-align_center"
    ): String = Jsoup.connect(schedulePage).get()
        .getElementsByClass(clazzName)
        .joinToString("\n") {
            it.children().attr(attribute)
        }
    fun parseIf2Content(
        clazzName: String = "t156__wrapper",
        subClazz: String = "t156__item"
    ): String = Jsoup.connect(schedulePage).get()
        .getElementsByClass(clazzName)
        .map {
            it.getElementsByClass(subClazz)
        }
        .flatten()
        .map { it.children().attr(attribute) }
        .joinToString("\n") { it.trim() }
}