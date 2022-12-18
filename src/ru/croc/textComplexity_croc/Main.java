package ru.croc.textComplexity_croc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<String> s = FrequentEnglishWorlds.frequentWorlds();
		Map<String, Integer> book = FrequencyDictionary.newFerqDict();
		Map<String, Integer> resMap = new HashMap<>();
		Map<String, Integer> d1= new HashMap<>();
		Map<String, Integer> d2= new HashMap<>();
		Map<String, Integer> d3= new HashMap<>();
		split(book, d1, d2, d3);
		ExecutorService eservice= Executors.newFixedThreadPool(3);
		eservice.execute(new Thread(new WordProcessing(s, d1)));
		eservice.execute(new Thread(new WordProcessing(s, d2)));
		eservice.execute(new Thread(new WordProcessing(s, d3)));
		eservice.shutdown();
		if(eservice.awaitTermination(1, TimeUnit.MINUTES)) {
			d1.forEach((k, v) -> resMap.putIfAbsent(k, v));
			d2.forEach((k, v) -> resMap.putIfAbsent(k, v));
			d3.forEach((k, v) -> resMap.putIfAbsent(k, v));
		}
		resMap.entrySet().removeIf(e -> e.getValue()>5);
		System.out.println("Список слов, относительно которых был сделан вывод о сложности вашего текса");
		System.out.println(resMap);
		System.out.println("\n"+"Программа заключила, что");
		if (resMap.size()==0) {
			throw new Exception("Многопоток отработал некорректно, попробуй еще раз");
		}else if(resMap.size()>150) {
			System.out.println("_____________Текст сложный_____________");			
		}else if (resMap.size()>70 & resMap.size()<100) {
			System.out.println("_____________Текст средний_____________");
		}else{
			System.out.println("_____________Текст легкий_____________");
		}
	}
	@SafeVarargs
	public static <T, U> void split(Map<T,U> map, Map<T,U>... array){
	    int i = 0;
	    for(Map.Entry<T, U> e : map.entrySet()){
	        array[i++% array.length].put(e.getKey(), e.getValue());
	    }
	}
}

 
