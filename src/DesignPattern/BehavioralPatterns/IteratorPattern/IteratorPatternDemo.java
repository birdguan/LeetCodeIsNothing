package DesignPattern.BehavioralPatterns.IteratorPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 20:37
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println("Name: " + name);
        }
    }
}
