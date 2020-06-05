package DesignPattern.BehavioralPatterns.CommandPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 19:40
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + "; Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + "; Quantity: " + quantity + " ] sold");
    }
}
