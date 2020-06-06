package DesignPattern.BehavioralPatterns.StrategyPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:50
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
