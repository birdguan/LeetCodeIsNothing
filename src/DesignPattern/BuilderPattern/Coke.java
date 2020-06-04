package DesignPattern.BuilderPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 21:42
 */
public class Coke extends ColDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
