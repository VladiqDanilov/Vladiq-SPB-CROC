package ru.croc.task12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Task12 {
	private static CommentCensor censor;
	public static void main(String[] args) {
		//
		List <String> forFilter=Arrays.asList( "foo", "bar", "baz", "neighbour", "Pavel", "Done!");
		//List of comments to filter
		HashSet <String> banWorlds = new HashSet<>(); //запрещенные worlds
		banWorlds.add("bar");
		banWorlds.add("foo");
		banWorlds.add("neighbour");
		censor = new CommentCensor(); //для использования метода абстрактного класса
		censor.filterComments(forFilter, banWorlds);
		StringBuilder builder = new StringBuilder();
		for (String value : forFilter) {
		    builder.append(value);
		}
		String text = builder.toString();
		System.out.println(text);
	}
	
}
