package DesignPattern.BehavioralPatterns.VisitorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 11:45
 */
public class Computer implements ComputerPart {
    ComputerPart[] computerParts;

    public Computer() {
        this.computerParts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < computerParts.length; i++) {
            computerParts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
