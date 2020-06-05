package DesignPattern.StructuralPatterns.FacadePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 16:10
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
