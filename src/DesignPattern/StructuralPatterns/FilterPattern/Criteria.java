package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:16
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> people);
}
