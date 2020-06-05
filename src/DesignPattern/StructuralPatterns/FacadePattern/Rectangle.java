package DesignPattern.StructuralPatterns.FacadePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 16:09
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
