package ru.croc.task15;
import java.util.List;

public class DescAge {
    String DescAge;
    List<Person> Persons;

    public DescAge(String DescAge, List<Person> Persons) {
        if (DescAge.isEmpty()) {
            throw new IllegalArgumentException("Incorrect data in DescAge");
        }
        this.DescAge = DescAge;
        this.Persons = Persons;
    }
    //вхождение
    //в вовзрастную группу

    @Override
    public String toString() {
        return  DescAge + ": " + Persons;
    }
}