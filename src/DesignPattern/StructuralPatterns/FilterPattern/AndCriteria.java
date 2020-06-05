package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:28
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> firstCriteriaPeople = criteria.meetCriteria(people);
        return otherCriteria.meetCriteria(firstCriteriaPeople);
    }
}
