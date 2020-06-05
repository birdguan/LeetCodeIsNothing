package DesignPattern.BehavioralPatterns.CommandPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 19:44
 */
public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
