package DesignPattern.BehavioralPatterns.MediatorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 20:50
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
