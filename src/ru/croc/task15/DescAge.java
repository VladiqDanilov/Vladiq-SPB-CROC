package ru.croc.task15;
import java.util.List;


public class DescAge {
	String descAge;
    List<Person> persons;

    public DescAge(String descAge, List<Person> persons) {
        if (descAge.isEmpty()) {
            throw new IllegalArgumentException("Incorrect data in DescAge");
        }
        this.descAge = descAge;
        this.persons = persons;
    }
  //вхождение
   //в вовзрастную группу
    
    @Override
    public String toString() {
        return  descAge + ": " + persons;
    }
}
