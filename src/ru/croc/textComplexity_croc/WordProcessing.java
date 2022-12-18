package ru.croc.textComplexity_croc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class WordProcessing implements Runnable {
	private ArrayList<String> mostUsed;
	private Map<String, Integer> text_tokens;
	
	public WordProcessing(ArrayList<String> mostUsed, Map<String, Integer> text_tokens) {
		super();
		this.mostUsed = mostUsed;
		this.text_tokens = text_tokens;
	}
	public void run() {
		Iterator<Map.Entry<String, Integer>> itr=text_tokens.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Integer> curPairEntry= itr.next();
			String crWord=curPairEntry.getKey();
			if(mostUsed.contains(crWord)) {
				itr.remove();
			}	
		}
		text_tokens.entrySet().removeIf(e -> e.getValue()>5);
	}
}
