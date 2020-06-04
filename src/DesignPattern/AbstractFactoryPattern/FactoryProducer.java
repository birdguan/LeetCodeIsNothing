package DesignPattern.AbstractFactoryPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 20:21
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
