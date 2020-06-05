package DesignPattern.StructuralPatterns.AdapterPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 11:20
 */
public class Vlcplayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
