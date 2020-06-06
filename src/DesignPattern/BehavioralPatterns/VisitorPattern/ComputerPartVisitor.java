package DesignPattern.BehavioralPatterns.VisitorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 11:42
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
