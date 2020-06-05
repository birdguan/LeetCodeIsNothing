package DesignPattern.BehavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 17:37
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
