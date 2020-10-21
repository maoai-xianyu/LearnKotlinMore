package net.println.kotlin.chapter06

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:35 下午
 */

fun main(args: Array<String>) {
    html {
        //properties["id"] = "HtmlId" // 转
        "id"("HtmlId")
        //children.add(Tag("head"))  // 转
        "head"{
            "id"("headId")
        }

        body {
            id = "bodyId"
            `class` = "bodyclass"
            "a"{
                "href"("https://www.coding.cn")
                +"kotlin 中文博客"
            }
        }
    }.render().let(::println)
}

fun ex1() {
    html {
        //properties["id"] = "HtmlId" // 转
        "id"("HtmlId")
        //children.add(Tag("head"))  // 转
        "head"{
            "id"("headId")
        }

        "body"{
            "a"{
                "href"("https://www.coding.cn")
                +"kotlin 中文博客"
            }
        }
    }.render().let(::println)
}

fun ex() {
    Tag("html").apply {
        properties["id"] = "HtmlId"
        children.add(Tag("head"))
    }.render().let(::println)
}