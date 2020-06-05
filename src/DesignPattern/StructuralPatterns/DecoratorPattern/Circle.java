package DesignPattern.StructuralPatterns.DecoratorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 15:45
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
