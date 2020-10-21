package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/29.
 *
 */

fun main(args: Array<String>) {

    visibleModifersFunOne()
    println("-------------------")
    visibleModifersFunTwo()
    println("-------------------")
}



/**
 * Classes and interFaces
 *
 *         private                              protected                                                                  internal                        public
 * java    visible within the declaring class   visible within own package(including declaring class) and its subclasses   not use                         visible everyWhere
 * Kotlin  visible within the declaring class   visible within the declaring class and its subclasses                      visible within the same module  visible everyWhere
 *
 * kotlin  private  ----->  package private
 *         internal ----->  public
 */
private fun visibleModifersFunTwo() {
    val e = ClassE()

    e.printlMe()
    val innerClass = ClassE.InnerClass()
    //innerClass.numA  访问不到
}


/**
 *
 * 可见性修饰符   private internal  protected public 修饰对象  class
 *
 *         package-private    protected    private                       internal                            public
 * java    default            not used     not use                       not have                           visible everyWhere
 * Kotlin  no                 not used     visible within the same file  visible within the same module     visible everyWhere defaut
 */
private fun visibleModifersFunOne() {
    val a = ClassA()
    val c = ClassC()
    val d = ClassD()
    val e = ClassE()
    println(a)
    println(c)
    println(d)
    println(e)
}


private class ClassA
class ClassC
class ClassD
internal class ClassE {
    internal fun printlMe() {
        println("this is class e")
    }


    class InnerClass {
        private val numA = 5
    }

    val innerClass = InnerClass()
    //val num = innerClass.numA

}