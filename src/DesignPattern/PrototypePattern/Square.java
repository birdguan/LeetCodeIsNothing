package DesignPattern.PrototypePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 10:21
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
