import org.jsoup.Jsoup

fun main() {
    println(foo())
}
// information https://hramalnevskogo.ru/page42533272.html
// spirit talk https://hramalnevskogo.ru/page40967215.html
fun foo(
    mainPage: String = "https://hramalnevskogo.ru/",
    clazzName: String = "tn-atom"
) = Jsoup.connect(mainPage)
    .get()
    .getElementsByClass(clazzName)
    .html()
    .replace("</?\\w*>".toRegex(), "\n")
    .replace("\\s\\s+".toRegex(), "\n")
    .split("\n".toRegex())
    .let {
        it.slice(8..it.lastIndex)
    }
    .joinToString("\n")
