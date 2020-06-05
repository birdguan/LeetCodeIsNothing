package DesignPattern.BehavioralPatterns.ObserverPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:49
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
