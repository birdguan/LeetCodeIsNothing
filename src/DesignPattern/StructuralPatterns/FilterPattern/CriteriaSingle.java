package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:26
 */
public class CriteriaSingle implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> singlePeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getMaritalStatus().equalsIgnoreCase("single")) {
                singlePeople.add(person);
            }
        }
        return singlePeople;
    }
}
