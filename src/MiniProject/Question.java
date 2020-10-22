package MiniProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Question {
    private ArrayList<String> questions = new ArrayList<>();                  // put all the cities in the arraylist
    private String question;                                                  // randomly chosen question
    private String convertedQuestion;                                         // chosen city in all small letters
    private String input;                                                     // user input
    private String convertedInput;                                            // user input in all small letters
    private char charInput;                                                   // user input in char type
    private char convertedCharInput;                                          // user char input in small letter
    private StringBuilder currentGuess = new StringBuilder();
    private ArrayList<Character> previousWrongGuesses = new ArrayList<>();    // Store user input (wrong)


    public Question() {
        this.previousWrongGuesses = previousWrongGuesses;
        this.currentGuess = currentGuess;
    }

    // getter methods
    public String getQuestion() {
        return question;
    }

    public String getConvertedQuestion(){
        return convertedQuestion;
    }

    public ArrayList getQuestions() {
        return questions;
    }

    public ArrayList getPreviousWrongGuesses() {
        return previousWrongGuesses;
    }

    public StringBuilder getCurrentGuess() {
        return currentGuess;
    }

    public char getCharInput() {
        return charInput;
    }

    public String getInput() {
        return input;
    }

    public String getConvertedInput() {
        return convertedInput;
    }

    public char getConvertedCharInput(){
        return convertedCharInput;
    }

    // methods
    /**
     * @return ArrayList questions
     */
    public ArrayList loadFile() {
        try {
            File file = new File("cities.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String city = fileScanner.nextLine();
                questions.add(city);
            }
        } catch (Exception e) {
            System.err.println("File not founded");
        }
        this.questions = questions;
        return questions;
    }

    /**
     * @return String question
     */
    public String pickCity() {
        double random = (Math.random() * questions.size());
        long randomNum = Math.round(random);
        int i = (int) randomNum;
        String question = questions.get(i);                         // 大文字小文字ミックスされた状態
        this.question = question;
        convertedQuestion = getQuestion().toLowerCase();            // 全て小文字に変換したもの
        this.convertedQuestion = convertedQuestion;
        return question;
    }

    /**
     * Convert question to underscore, and display
     */
    public  void displayQuestion() {
        int length = getQuestion().length();                        // length of chosen city
        for (int i = 0; i < length; i++) {
            String str = getQuestion().substring(i, i+ 1);
            char ch = question.charAt(i);
            if (Character.isWhitespace(ch)) {     //str.equals(" ")   // 文字がないところはunderbarでreplaceしない
                currentGuess.replace(i, i + 1, " ");
            }
            currentGuess.replace(i, i + 1, "_");
        }
        System.out.println("Here's the question.\n" + getCurrentGuess());
    }

    /**
     * take user's input, return if the input is in the question
     * @return boolean
     */
    public boolean isInQuestion() {
        System.out.print("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        this.input = input; // user input
        convertedInput = getInput().toLowerCase();                      // convert user input all small letter
        this.convertedInput = convertedInput;
        convertedCharInput = convertedInput.charAt(0);                  // charとして小文字で指定
        this.convertedCharInput = convertedCharInput;
        char charInput = input.charAt(0);                               // user input(char ver)
        this.charInput = charInput;

        System.out.println("Your guess: " + getInput());
        if (getConvertedQuestion().contains(getConvertedInput())) {     //小文字同士で比較
            return true;
        } else {
            return false;
        }
    }

    /**
     * reveal correct letters and display
     * @return StringBuilder
     */
    public StringBuilder displayGuess() {
        for (int i = 0; i < getQuestion().length(); i++) {
            if (getConvertedQuestion().charAt(i) == getConvertedCharInput()) {  //小文字で比較
                char ch1 = getQuestion().charAt(i);
                String str = String.valueOf(ch1);
                currentGuess.replace(i, i + 1, str);                        //入れ替えにquestion stringのi番の文字持ってくる
            }
        }
        this.currentGuess = currentGuess;
        return currentGuess;
    }

    /**
     * check if the input was previously mistaken one
     * @return boolean
     */
    public boolean isWrongBefore() {
        for (int i = 0; i < getPreviousWrongGuesses().size() ; i++) {
            if (getCharInput() == previousWrongGuesses.get(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * check it the game over or not
     * @return boolean
     */
    public boolean isOver(){
        if (! getCurrentGuess().toString().contains("_")){
            return true;
        }
        else if (getPreviousWrongGuesses().size() == 10){
            return true;
        }
        return false;
    }
}


