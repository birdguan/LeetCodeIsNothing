package DesignPattern.BuilderPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/4 21:33
 */

/**
 * 食物条目接口
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
