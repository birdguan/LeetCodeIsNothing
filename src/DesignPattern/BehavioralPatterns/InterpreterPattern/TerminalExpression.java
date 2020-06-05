package DesignPattern.BehavioralPatterns.InterpreterPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 20:01
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
