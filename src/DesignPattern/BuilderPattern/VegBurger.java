package DesignPattern.BuilderPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 21:40
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
