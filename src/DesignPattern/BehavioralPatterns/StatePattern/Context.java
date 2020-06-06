package DesignPattern.BehavioralPatterns.StatePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:09
 */
public class Context {
    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
