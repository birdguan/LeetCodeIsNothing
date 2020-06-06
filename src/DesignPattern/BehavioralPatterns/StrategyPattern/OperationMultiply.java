package DesignPattern.BehavioralPatterns.StrategyPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:52
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
