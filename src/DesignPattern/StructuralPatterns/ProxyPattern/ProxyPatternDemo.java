package DesignPattern.StructuralPatterns.ProxyPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 17:10
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");

        image.display();
        image.display();
    }
}
