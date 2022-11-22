package ru.croc.task10;

import java.util.List;

// выбор рандомного именени пользователя для ставки
public class RandChoiceName {
	public String getRandom() {
		List<String> buyerNam=List.of("Lexa", "Vasya", "Aleksandr", "Anastasia", "Alena", "Igor", "Olga");
		int raindomIndex = (int)(Math.random()*buyerNam.size());
		String randomElement = buyerNam.get(raindomIndex);
		return randomElement;
	}
}

