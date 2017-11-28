package com.pangpang.mvnbook.helloworld;

/**
 * Created by leewake on 2017/11/28
 *
 * 参考链接：
 * http://blog.csdn.net/kavensu/article/details/8067850
 */
public class TryCatchTest {

    public static void main(String[] args) {

        System.out.println("测试程序开始");

        int result = test();
        System.out.println(result);

        Person person = testReference();
        System.out.println(person.getName());

        System.out.println("测试程序结束");

    }

    /**
     * 当finally中没有return值，但改变了要返回的值，分为两种情况
     * @return
     */

    /**
     * 类似于按值传递
     * 如果return的数据是基本数据类型或文本字符串，则在finally中对该基本数据的改变不起作用，
     * try中的return语句依然会返回进入finally块之前保留的值。
     * @return
     */
    public static int test(){
        int x = 0;

        try{
            System.out.println("执行try方法");
            x++;
            int y = x / 0;
            System.out.println("-----" + x + "------");
            return x;
        }catch (RuntimeException e){
            System.out.println("程序发生异常");
            ++x;
            System.out.println("-----" + x + "------");
            return x;
        }finally {
            System.out.println("程序执行finally方法");
            x++;
            System.out.println("-----" + x + "------");
            //return x;
        }
    }

    /**
     * 类似于按引用传递
     * 如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，
     * try中的return语句返回的就是在finally中改变后的该属性的值。
     * @return
     */
    public static Person testReference(){

        Person person = new Person("haha");

        try{
            System.out.println("执行try方法");
            person.setName("try");
            System.out.println("-----" + person.getName() + "------");
            return person;
        }catch (RuntimeException e){
            System.out.println("程序发生异常");
            person.setName("catch");
            System.out.println("-----" + person.getName() + "------");
            return person;
        }finally {
            System.out.println("程序执行finally方法");
            person.setName("finally");
            System.out.println("-----" + person.getName() + "------");
            //return person.getName();
        }
    }

    public static class Person{
        private String name;

        public Person(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
