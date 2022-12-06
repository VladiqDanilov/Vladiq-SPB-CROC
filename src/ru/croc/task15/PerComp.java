package ru.croc.task15;
import java.util.Comparator;
//Компоратор, пытался имплиментить в Person,
//но он необходим в отдельном классе для корректного вывода
public class PerComp implements Comparator<Person> {
	@Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() == o2.getAge()) {
            return o1.getname().compareTo(o2.getname());
        }
        return o2.getAge() - o1.getAge();
    }
}
