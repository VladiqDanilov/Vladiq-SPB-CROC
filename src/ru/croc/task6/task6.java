package ru.croc.task6;

import java.io.IOException;
import java.util.Scanner;

public class task6 {
	public static void main(String[] args) {
		/*
		System.out.print("Введите путь к обрабатываемому файлу:");
		Scanner s = new Scanner(System.in);
        String fimeName = s.nextLine();
		try {
            System.out.println(CommentRemover.removeJavaCommentsFile(fimeName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        CommentRemover commentRemover = new CommentRemover();
        String codeSecond = "public class HelloVladiq{\r\n"
        		+ "	  public static void main(String[] args) { //Запускаем возвращаемый метод\r\n"
        		+ "	  /*\r\n"
        		+ "	  Принтим некоторые значения,\r\n"
        		+ "	  */\r\n"
        		+ "	  //они будут видны в терминале\r\n"
        		+ "		    System.out.println(\"It's Vladiq write on [Java]\");\r\n"
        		+ "			/*\r\n"
        		+ "			Владислав, с уважением\r\n"
        		+ "			*/\r\n"
        		+ "			//к вам */\r\n"
        		+ "			/*\r\n"
        		+ "			ко всем\r\n"
        		+ "			*/\r\n"
        		+ "			\r\n"
        		+ "		  }\r\n"
        		+ "		}";
        System.out.println(CommentRemover.removeJavaCommentsStringRegex(codeSecond));
    }
}
