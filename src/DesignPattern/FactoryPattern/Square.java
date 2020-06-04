package DesignPattern.FactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 19:40
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
