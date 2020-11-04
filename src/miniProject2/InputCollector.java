package miniProject2;

/*This is to handle user input*/

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class InputCollector {
    // data field
    private String prompt;

    public InputCollector(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    // take in a single string parameter 'prompt', and
    // return whatever text the user inputs after that prompt
    /// 最初のボードの選択肢に対するインプットを入手するメソッド
    public static String getUserInput(String prompt) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }

    public static int getUserIntInput(String prompt){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        return input;
    }



}



    // 1 -> List all Contacts
    // 2 -> Add new Contact
    // 3 -> Remove Contact
    // 4 -> Update Contact
    // 5 -> Quit

