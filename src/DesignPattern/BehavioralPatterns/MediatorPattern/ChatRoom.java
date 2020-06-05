package DesignPattern.BehavioralPatterns.MediatorPattern;

import java.util.Date;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 20:49
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + "[" + user.getName() + "]" + message);
    }
}
