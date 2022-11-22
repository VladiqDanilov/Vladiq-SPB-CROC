package ru.croc.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommentRemover {
    public static String removeJavaCommentsStringRegex(String fileCode) {
        return fileCode.replaceAll("//.*|/\\*(?s:.*?)\\*/", "");
        //Удаление комментариев из строки с помощью регулярного выражения
    }

    // Удаление комментариев из файла
    public static String removeJavaCommentsFile(String fileName) throws IOException {
        String allText = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String curLine = bufferedReader.readLine();

            while (curLine != null) {
                stringBuilder.append(curLine);
                stringBuilder.append(System.lineSeparator());
                curLine = bufferedReader.readLine();
            }
            allText = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert allText != null;
        return(removeJavaCommentsStringRegex(allText));
    }
}


