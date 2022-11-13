package ru.croc.task6;

public class task6 {
	public static void main(String[] args) {
        CommentRemover commentRemover = new CommentRemover();
        String code = "/*\r\n"
        		+ " * My first ever program in Java!\r\n"
        		+ " */\r\n"
        		+ "class Hello { // class body starts here \r\n"
        		+ "  \r\n"
        		+ "  /* main method */\r\n"
        		+ "  public static void main(String[] args/* we put command line arguments here*/) {\r\n"
        		+ "    // this line prints my first greeting to the screen\r\n"
        		+ "    System.out.println(\"Hi!\"); // :)\r\n"
        		+ "  }\r\n"
        		+ "} // the end\r\n"
        		+ "// to be continued...\r\n"
        		+ "";
        System.out.println(commentRemover.removeJavaCommentsString(code));
    }
}
