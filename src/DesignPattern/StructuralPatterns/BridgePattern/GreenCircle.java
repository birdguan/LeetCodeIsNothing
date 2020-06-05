package DesignPattern.StructuralPatterns.BridgePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 11:51
 */
public class GreenCircle implements DrawAPI{
    @Override
    public void drawable(int radius, int x, int y) {
        System.out.println("Drawing Circle [color: green, radius: " + radius + "; x: " + x + "; y: " + y + "]");
    }
}
