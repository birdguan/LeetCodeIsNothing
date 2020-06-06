package DesignPattern.BehavioralPatterns.TemplatePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 11:25
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
