package DesignPattern.BehavioralPatterns.StatePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:10
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Play is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StartState{}";
    }
}
