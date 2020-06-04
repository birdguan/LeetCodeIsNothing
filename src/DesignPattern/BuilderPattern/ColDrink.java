package DesignPattern.BuilderPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 21:39
 */
public abstract class ColDrink implements Item{
    /**
     * 冷饮装在瓶子里
     * @return
     */
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
