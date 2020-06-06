package DesignPattern.BehavioralPatterns.VisitorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 11:44
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
