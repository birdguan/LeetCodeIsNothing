package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:22
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> femalePeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equalsIgnoreCase("female")) {
                femalePeople.add(person);
            }
        }
        return femalePeople;
    }
}
