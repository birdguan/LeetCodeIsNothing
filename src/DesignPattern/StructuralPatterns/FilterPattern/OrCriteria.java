package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:33
 */
public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> firstCriteriaPeople = criteria.meetCriteria(people);
        List<Person> secondCriteriaPeople = criteria.meetCriteria(people);

        for (Person person : secondCriteriaPeople) {
            if (! firstCriteriaPeople.contains(person)) {
                firstCriteriaPeople.add(person);
            }
        }
        return firstCriteriaPeople;
    }
}
