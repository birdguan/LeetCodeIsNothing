package DesignPattern.StructuralPatterns.BridgePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 11:48
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawable(int radius, int x, int y) {
        System.out.println("Drawing Circle [color: red, radius: " + radius + "; x: " + x + "; y: " + y + "]");
    }
}
