package com.pangpang.mvnbook.generic;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class Rectangle<T> {

    private T length;

    private T width;

    public Rectangle(T length, T width) {
        this.length = length;
        this.width = width;
    }

    public T getLength() {
        return length;
    }

    public void setLength(T length) {
        this.length = length;
    }

    public T getWidth() {
        return width;
    }

    public void setWidth(T width) {
        this.width = width;
    }

/*    public static  void main(String[] args){
        Integer width = 10;
        Integer length = 20;

        Rectangle<Integer> rectangle = new Rectangle<Integer>(width, length);

        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getClass());
    }*/
}
