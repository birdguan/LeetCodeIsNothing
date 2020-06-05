package DesignPattern.StructuralPatterns.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: birdguan
 * @Date: 2020/6/5 14:36
 */
public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Robert","Male", "Single"));
        people.add(new Person("John","Male", "Married"));
        people.add(new Person("Laura","Female", "Married"));
        people.add(new Person("Diana","Female", "Single"));
        people.add(new Person("Mike","Male", "Single"));
        people.add(new Person("Bobby","Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(people));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(people));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(people));

        System.out.println("\nSingle Or Females");
        printPersons(singleOrFemale.meetCriteria(people));
    }

    private static void printPersons(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

}
