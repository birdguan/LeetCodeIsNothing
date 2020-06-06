package DesignPattern.BehavioralPatterns.StrategyPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:56
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = ");
        System.out.println(context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = ");
        System.out.println(context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = ");
        System.out.println(context.executeStrategy(10, 5));
    }
}
