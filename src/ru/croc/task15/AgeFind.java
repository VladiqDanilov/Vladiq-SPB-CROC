package ru.croc.task15;
import java.util.ArrayList;
import java.util.List;
public class AgeFind {
	 public static List<DescAge> createGroups(String ages, List<String[]> Persons) {
	        List<DescAge> rezultGroups = new ArrayList<>();
	        String[] ageBounds = ages.split(" ");
	        int min = 0;
	        int max = 0;
	        for (int i = 0; i <= ageBounds.length; i++) {
	            List<Person> groupPersons = new ArrayList<>();
	            String diapasone;
	            if (i == 0) {
	                min = 0;
	                max = Integer.parseInt(ageBounds[i]);
	            } else if (i == ageBounds.length){
	                min = Integer.parseInt(ageBounds[i - 1]) + 1;
	                max = Integer.MAX_VALUE;
	            } else {
	                min = Integer.parseInt(ageBounds[i - 1]) + 1;
	                max = Integer.parseInt(ageBounds[i]);
	            }
	            for (String[] curPerson : Persons) {
	                if (Integer.parseInt(curPerson[1]) >= min && Integer.parseInt(curPerson[1]) <= max) {
	                    groupPersons.add(new Person(Integer.parseInt(curPerson[1]), curPerson[0]));
	                }
	            }
	            if (!groupPersons.isEmpty()) {
	                if (i == ageBounds.length) {
	                    diapasone = min + "+";
	                } else {
	                    diapasone = min + "-" + max;
	                }
	                groupPersons.sort((p1, p2) -> new PerComp().compare(p1, p2)); 
	                rezultGroups.add(new DescAge(diapasone, groupPersons)); //создание групп по
	                //входным данным
	            }
	        }
	        return rezultGroups;
	    }
}
