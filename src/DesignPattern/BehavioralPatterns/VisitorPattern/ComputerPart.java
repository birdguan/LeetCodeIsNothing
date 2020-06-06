package DesignPattern.BehavioralPatterns.VisitorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 11:41
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
