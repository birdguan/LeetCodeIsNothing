package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:20
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> malePeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equalsIgnoreCase("male")) {
                malePeople.add(person);
            }
        }
        return malePeople;
    }
}
