package DesignPattern.CreationalPatterns.AbstractFactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 20:12
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
