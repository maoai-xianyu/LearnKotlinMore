package net.println.kotlin.chapter04;

/**
 * @author zhangkun
 * @time 2020/5/27 4:40 下午
 */
public class InnerClassJava {

    private int a = 10;
    // 非静态内部类持有外部类的状态，也就是持有引用，会造成内存泄漏的
    public class Inner {
        public void hello() {
            System.out.println(a);
            System.out.println(InnerClassJava.this.a);
        }
    }
    // 静态内部类不在持有外部类
    public static class Outer {
    }
    public static void main(String[] args) {
        InnerClassJava innerClassJava = new InnerClassJava();
        Inner inner = innerClassJava.new Inner();

        Outer outer = new Outer();

    }
}
