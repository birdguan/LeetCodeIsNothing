package DesignPattern.StructuralPatterns.DecoratorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 15:44
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
