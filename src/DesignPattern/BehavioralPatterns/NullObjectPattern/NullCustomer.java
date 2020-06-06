package DesignPattern.BehavioralPatterns.NullObjectPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:28
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in customer database";
    }
}
