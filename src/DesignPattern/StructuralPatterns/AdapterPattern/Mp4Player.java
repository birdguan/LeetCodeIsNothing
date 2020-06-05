package DesignPattern.StructuralPatterns.AdapterPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 11:21
 */
public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
