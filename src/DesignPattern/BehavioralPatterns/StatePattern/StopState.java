package DesignPattern.BehavioralPatterns.StatePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:13
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StopState{}";
    }
}
