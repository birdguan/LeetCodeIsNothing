package DesignPattern.CreationalPatterns.BuilderPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 21:43
 */
public class Pepsi extends ColDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
