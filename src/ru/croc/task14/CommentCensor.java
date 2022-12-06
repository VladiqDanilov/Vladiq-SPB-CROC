package ru.croc.task14;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class CommentCensor {
	// теперь CommentCensor не наследует BlackListFilter, а передает коллекции для
	//его работы
	public List<String> filterComments(List<String> comments, Set<String> blackList) {
        BlackListFilter<String> filter = new BlackListFilter<>() {};
        Predicate<String> predicate = comment -> {
            String[] words = comment.toLowerCase().split(" ");
            for (String word : words) {
                if (blackList.contains(word)) {
                    return true;
                }
            }
            return false;
        };
        return (List<String>)filter.filterComments(comments, predicate);
    }
}
