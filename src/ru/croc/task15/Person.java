package ru.croc.task15;

public class Person {
    private Integer age;
    private String name;

  //для реализации сортировки без лябмда - compare
    public Person(Integer age, String name) {
        if (age > 123 || name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect person data!");
        }
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getname() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) {
            return false;
        }

        if (!age.equals(person.age)) return false;
        return name.equals(person.name);
    }
    @Override
    public String toString() {
        return name + " (" + age + ')';
    }
}
