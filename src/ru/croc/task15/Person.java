package ru.croc.task15;

public class Person {
	private Integer age;
	private String name;

//для соблюдение условий по возрасту
	public Person(Integer age, String name) {
		if (age > 123 || name.isEmpty()) {
			throw new IllegalArgumentException("Incorrect Person data!");
		}
		this.age = age;
		this.name = name;
	}

	public String getname() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name + " (" + age + ')';
	}
}
