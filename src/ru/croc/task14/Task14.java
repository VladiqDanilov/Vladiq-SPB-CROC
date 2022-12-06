package ru.croc.task14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task14 {
	public static void main(String[] args) {
		// List of comments to filter
		List<String> forFilter = new ArrayList<>(Arrays.asList("foo", "bar", "baz", "neighbour", "Pavel", "nice",
				"sprites", "scary", "monsters", "Done!"));
		// Ban words
		Set<String> banWorlds = new HashSet<>(Arrays.asList("bar", "foo", "neighbour", "nice", "scary", "sprites"));
		CommentCensor censor = new CommentCensor();
		List<String> firstDelRezults = censor.filterComments(forFilter, banWorlds);
		System.out.println(firstDelRezults.toString());
	}
}
