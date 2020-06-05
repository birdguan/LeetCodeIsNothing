package DesignPattern.StructuralPatterns.BridgePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 11:52
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape (DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
