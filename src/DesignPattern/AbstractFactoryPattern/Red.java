package DesignPattern.AbstractFactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 20:09
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
