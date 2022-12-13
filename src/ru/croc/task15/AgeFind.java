package ru.croc.task15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class AgeFind {
	public static List<DescAge> createGroups(String[] ages, List<String[]> users) {
        List<DescAge> grouRes = new ArrayList<>();
        Comparator<Person> userCompare = (Person o1, Person o2) -> {
            if (Objects.equals(o1.getAge(), o2.getAge())) {
                return o1.getname().compareTo(o2.getname());
            }
            return o2.getAge() - o1.getAge();
        };

        int min;
        int max;
        for (int i = 0; i <= ages.length; i++) {
            List<Person> groupPersons = new ArrayList<>();
            String diapasone;
            if (i == 0) {
                min = 0;
                max = Integer.parseInt(ages[i]);
            } else if (i == ages.length){
                min = Integer.parseInt(ages[i - 1]) + 1;
                max = Integer.MAX_VALUE;
            } else {
                min = Integer.parseInt(ages[i - 1]) + 1;
                max = Integer.parseInt(ages[i]);
            }
            for (String[] curUser : users) {
                int curUserAge = Integer.parseInt(curUser[1]);
                if (curUserAge >= min && curUserAge <= max) {
                    groupPersons.add(new Person(curUserAge, curUser[0]));
                }
            }
            if (!groupPersons.isEmpty()) {
                if (i == ages.length) {
                    diapasone = min + "+";
                } else {
                    diapasone = min + "-" + max;
                }
                groupPersons.sort(userCompare);
                grouRes.add(new DescAge(diapasone, groupPersons));
            }
        }
        return grouRes;
    }
}
