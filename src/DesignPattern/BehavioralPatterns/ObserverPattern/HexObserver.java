package DesignPattern.BehavioralPatterns.ObserverPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:57
 */
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
