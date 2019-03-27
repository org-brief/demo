package com.example.demo.jvm;

/**
 * @author wanghuan
 * Date: 2019/3/18
 * Time: 22:14
 * Email: wanghuan29@jd.com
 */
public class JvmStaticTest {

    public static void main(String[] args) {
        staticFunction();

        System.out.println(jvmStaticTest);
    }

    static JvmStaticTest jvmStaticTest = new JvmStaticTest();

    int  a = 110;
    static int b = 112;

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    JvmStaticTest(){
        System.out.println("3");
        System.out.println("a=" + a + ", b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }


}
