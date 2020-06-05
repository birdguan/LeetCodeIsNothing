package DesignPattern.BehavioralPatterns.CommandPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 19:45
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();
    }
}
