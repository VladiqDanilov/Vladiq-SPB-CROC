package ru.croc.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommentRemover {

    public String removeJavaCommentsString(String fileCode) {
    	String ithem = "";
    	String[] sourceCodeStr = fileCode.split("\n");
        ArrayList<String> result = new ArrayList<>();
        StringBuilder strRes = new StringBuilder();
        boolean texIndex = false;
        
        //string parsing

        for (String curLine : sourceCodeStr) {
            if (!texIndex) {
                ithem = "";
            }

            for (int i = 0; i < curLine.length(); i++) {
                if (texIndex) {
                    if (curLine.charAt(i) == '*' && i + 1 < curLine.length() && curLine.charAt(i + 1) == '/') {
                        texIndex = false;
                        i++;
                    }
                } else {
                    if (curLine.charAt(i) == '/' && i + 1 < curLine.length() && curLine.charAt(i + 1) == '/') {
                        if ((i - 1 == -1 || curLine.charAt(i-1) != '"')) {
                            break;
                        }
                    }

                    if (curLine.charAt(i) == '/' && i + 1 < curLine.length() && curLine.charAt(i + 1) == '*') {
                        if ((i - 1 == -1 || curLine.charAt(i-1) != '"')) {
                            texIndex = true;
                            i++;
                            continue;
                        }
                    }
                    ithem += curLine.charAt(i);
                }
            }
            if (!texIndex) {
                if (ithem.length() > 0) {
                    result.add(ithem);
                }
            }
        }
        for (String i : result) {
        	strRes.append(i).append("\n");
        }
        return strRes.toString();
    }

    public String removeJavaCommentsFile(String fileName) throws IOException {
        String allText = null;
        try (BufferedReader addReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String curLine = addReader.readLine();
            //delete comments from the source code
            while (curLine != null) {
                stringBuilder.append(curLine);
                stringBuilder.append(System.lineSeparator());
                curLine = addReader.readLine();
            }
            allText = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert allText != null;
        return(removeJavaCommentsString(allText));
    }
}


