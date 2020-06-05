package DesignPattern.BehavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 17:36
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
