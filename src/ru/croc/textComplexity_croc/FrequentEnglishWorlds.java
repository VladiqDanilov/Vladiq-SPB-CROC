package ru.croc.textComplexity_croc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FrequentEnglishWorlds {
	public static ArrayList<String> frequentWorlds() {
		String fileName = "freqEngWord.txt";
		try {
			ArrayList<String> FreqWorlds = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
			return FreqWorlds;
		} catch (IOException e) {
			return null;
		}
	}
}
