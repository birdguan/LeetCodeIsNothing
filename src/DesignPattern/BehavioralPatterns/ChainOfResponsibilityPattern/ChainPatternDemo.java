package DesignPattern.BehavioralPatterns.ChainOfResponsibilityPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 17:39
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.ERROR);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "this is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug information");

        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
