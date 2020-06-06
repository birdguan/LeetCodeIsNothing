package DesignPattern.BehavioralPatterns.NullObjectPattern;

/**
 * @Author: birdguan
 * @Date: 2020/6/6 10:27
 */
public class RealCustomer extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
