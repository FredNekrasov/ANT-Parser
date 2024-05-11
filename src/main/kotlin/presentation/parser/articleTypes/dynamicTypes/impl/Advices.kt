package presentation.parser.articleTypes.dynamicTypes.impl

import presentation.parser.articleTypes.dynamicTypes.DATParser

class Advices : DATParser() {
    override fun parseContent(
        url: String,
        clazzName: String,
        attribute: String
    ): String = parseData(url).getElementById("feed-cover")?.getElementsByTag("img")?.attr("src") ?: ""
}