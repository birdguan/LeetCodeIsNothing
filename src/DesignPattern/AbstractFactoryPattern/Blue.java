package DesignPattern.AbstractFactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 20:10
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
