package DesignPattern.BuilderPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 21:37
 */
public abstract class Burger implements Item{
    /**
     * 汉堡在纸包装
     * @return
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }

}
