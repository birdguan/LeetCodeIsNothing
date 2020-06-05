package DesignPattern.PrototypePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 10:14
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
