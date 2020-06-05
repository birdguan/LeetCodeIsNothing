package DesignPattern.BehavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 17:35
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
