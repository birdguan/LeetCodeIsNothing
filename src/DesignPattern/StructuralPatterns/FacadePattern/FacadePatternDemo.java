package DesignPattern.StructuralPatterns.FacadePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 16:13
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
