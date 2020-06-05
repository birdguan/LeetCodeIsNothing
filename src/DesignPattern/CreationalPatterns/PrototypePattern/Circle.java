package DesignPattern.CreationalPatterns.PrototypePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 10:22
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw method.");
    }
}
