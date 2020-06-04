package DesignPattern.FactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 19:41
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
