package ru.croc.textComplexity_croc;

import java.io.*;
import java.util.*;

public class FrequencyDictionary {
	public static Map<String, Integer> newFerqDict(){
		System.out.println("Введите путь к Файлу");
		Scanner inScanner= new Scanner(System.in);
		String fileName= inScanner.nextLine();
		Map<String, Integer> map = new HashMap<String, Integer>();
		try(FileReader fr= new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)){
			String stringLine= br.readLine();
			stringLine=preprocessing(stringLine);
			while(stringLine!=null) {
				stringLine=preprocessing(stringLine);
				String[] words=stringLine.split(" ");
				for(String word: words) {
					if(map.containsKey(word)) {
						map.replace(word, map.get(word)+1);
					}else {
						map.put(word, 1);
					}
				}
				stringLine=br.readLine();
			}
			br.close();
		}catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return null;
		}
		catch (IOException e) {
			System.out.printf("IOException: %s", e.fillInStackTrace());
			return null;
		}
		return map;
	}
	public static String preprocessing(String s) {
		String res=s.replaceAll("[^a-zA-Z0-9]", " ");
		res=res.toLowerCase();
		return res;
	}
}
