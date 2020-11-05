package miniProject2;

/**
 * InputCollector handles user input
 */

import java.util.Scanner;

public class InputCollector {

    private String prompt;

    public InputCollector(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }


    /**
     * Take string parameter and return user string inputs
     * @param prompt
     * @return str
     */
    public static String getUserInput(String prompt) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }
}


