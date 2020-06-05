package DesignPattern.BehavioralPatterns.MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:17
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
