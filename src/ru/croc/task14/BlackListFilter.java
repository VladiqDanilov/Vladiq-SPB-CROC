package ru.croc.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
//используются предикаты для проверки подусловий
public interface BlackListFilter<T> {
	default Collection<T> filterComments(Iterable<T> comments, Predicate<T> shape) {
		Collection<T> censoredLine = new ArrayList<>();
		for (T comment : comments) {
			if (!shape.test(comment)) {
				censoredLine.add(comment);
			}
		}
		return censoredLine;
	}
}
