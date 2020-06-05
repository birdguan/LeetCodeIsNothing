package DesignPattern.BehavioralPatterns.MediatorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 21:00
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
