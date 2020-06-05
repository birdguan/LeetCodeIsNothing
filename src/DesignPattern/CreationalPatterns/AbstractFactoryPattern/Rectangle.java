package DesignPattern.CreationalPatterns.AbstractFactoryPattern;


/**
 * @Author: birdguan
 * @Date: 2020/6/4 19:39
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
