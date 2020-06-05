package DesignPattern.BehavioralPatterns.ObserverPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:54
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
