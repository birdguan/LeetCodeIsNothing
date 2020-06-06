package DesignPattern.BehavioralPatterns.TemplatePattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 11:22
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
