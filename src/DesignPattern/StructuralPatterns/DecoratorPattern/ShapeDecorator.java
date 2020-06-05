package DesignPattern.StructuralPatterns.DecoratorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 15:48
 */
public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
