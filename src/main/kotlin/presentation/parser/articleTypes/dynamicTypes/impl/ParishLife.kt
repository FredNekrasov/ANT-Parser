package presentation.parser.articleTypes.dynamicTypes.impl

import presentation.parser.articleTypes.dynamicTypes.DATParser

class ParishLife : DATParser() {
    override fun parseDescription(
        url: String,
        clazzName: String
    ): String = super.parseDescription(url, "t-feed__post-popup__text-wrapper")
}