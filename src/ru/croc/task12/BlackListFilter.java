package ru.croc.task12;

import java.util.List;
import java.util.Set;

public abstract class BlackListFilter {
	 /**
	   * From the given list of comments removes ones 
	   * that contain words from the black list.
	   * 
	   * @param comments list of comments; every comment 
	   *                 is a sequence of words, separated 
	   *                 by spaces, punctuation or commBar breaks   
	   * @param blackList list of words that should not 
	   *                  be present in a comment
	   */
	public void filterComments(List<String> comments, Set<String> blackList) {
		for (String commBar : comments) {
			String[] s = commBar.split("\\s");
			String res = "";
			for (String item : s) {
				String[] up = item.toLowerCase().split(",");
				if (!blackList.contains(up[0])) {
					res = res + item + " ";
				} else {
					int i = up[0].length(); //censoring of comments 
					String star = "*";
					String cnt = star.repeat(i);//
					res = res + cnt + " ";
				}
			}
			comments.set(comments.indexOf(commBar), res);
		}
	}
}
