package DesignPattern.BehavioralPatterns.ObserverPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:59
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state changed: 15");
        subject.setState(15);
        System.out.println("Second state changed: 10");
        subject.setState(10);
    }
}
