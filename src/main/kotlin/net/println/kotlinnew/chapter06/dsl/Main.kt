package net.println.kotlinnew.chapter06.dsl

import java.io.File

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:35 下午
 */

fun main(args: Array<String>) {
    val htmlContent = html{
        head {
            "meta" { "charset"("UTF_8") }
        }
        body {
            "div"{
                "style"(
                    """
                        width:200px;
                        height:200px;
                        line-height:200px;
                        background-color:#C9394A;
                        text-align:center
                    """.trimIndent()
                )
                "span"{
                    "style"(
                        """
                        color:white;
                        font-family:Microsoft YaHei
                    """.trimIndent()
                    )
                    +"hello html Dsl"
                }
            }
        }
    }.render()

    println("htmlContent $htmlContent ")

    File("kotlin.html").writeText(htmlContent)
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
    BlockNode("html").apply {
        properties["id"] = "HtmlId"
        children.add(BlockNode("head"))
    }.render().let(::println)
}