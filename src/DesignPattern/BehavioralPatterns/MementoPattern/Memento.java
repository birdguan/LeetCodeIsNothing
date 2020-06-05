package DesignPattern.BehavioralPatterns.MementoPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:14
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
