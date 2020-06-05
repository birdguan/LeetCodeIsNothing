package DesignPattern.CreationalPatterns.AbstractFactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 20:10
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
