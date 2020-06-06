package DesignPattern.BehavioralPatterns.StrategyPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:54
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
