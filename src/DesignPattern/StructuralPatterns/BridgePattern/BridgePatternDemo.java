package DesignPattern.StructuralPatterns.BridgePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 11:56
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 100, 100, 10);
        Shape greenCircle = new Circle(new GreenCircle(), 100, 100, 10);

        redCircle.draw();
        greenCircle.draw();
    }
}
