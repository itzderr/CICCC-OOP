package MiniProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Question {
    // data field
    private ArrayList<String> questions = new ArrayList<>();  // put all the cities in the arraylist
    private String question; // randomly chosen question
    //    private char[] charQuestion; // char array after chosen question in string converted
    private ArrayList<Character> previousCorrectGuesses = new ArrayList<>(); // Store user input (correct)
    private ArrayList<Character> previousWrongGuesses = new ArrayList<>(); // Store user input (wrong)
    private StringBuilder currentGuess = new StringBuilder();
    private char charInput;
    private String input;



    // constructor field // to set the initialized value(if I want user to set the initialized value)
    public Question() {
        this.previousWrongGuesses = previousWrongGuesses;
        this.previousCorrectGuesses = previousCorrectGuesses;
        this.currentGuess = currentGuess;
    }

    // getter
    public String getQuestion() {
        return question;
    }

    public ArrayList getQuestions() {
        return questions;
    }

    public ArrayList getPrevioudWrongGuesses() {
        return previousWrongGuesses;
    }

    public ArrayList getPreviousCorrectGuesses() {
        return previousCorrectGuesses;
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



    //OK : Read file and store the city into ArrayList(question)

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

    // pick a random city, return char array of the string

    /**
     * @return String question
     */
    public String pickCity() {
        double random = (Math.random() * questions.size());
        long randomNum = Math.round(random);
        int i = (int) randomNum;
        String question = questions.get(i);
        this.question = question;
        return question;
    }

    // Convert its letters to underscores, and display
    public void displayQuestion() {
        int length = question.length(); // length of chosen city
        for (int i = 0; i < length; i++) {
            char ch = question.charAt(i);
            if(!"".equals(ch)) {
                currentGuess.replace(i, i + 1, "_");
            }
        }
        System.out.println(currentGuess);
    }


    //    take user's input, search for it in the city (-> boolean)
    public boolean isInQuestion() {
        System.out.print("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        this.input = input;
        //convert user input from string to char
        char charInput = input.charAt(0);
        this.charInput = charInput;
        System.out.println("Your guess: " + charInput);
        if (getQuestion().indexOf(input) == -1) {
            return false;
        } else {
            return true;
        }
    }

    // reveal correct letters and display (-> string)
    public void displayGuess() {
        for (int i = 0; i < getQuestion().length(); i++) {
            if (question.charAt(i) == getCharInput()) {
                currentGuess.replace(i, i + 1, getInput());
            }
        }
        System.out.println(currentGuess);
    }

    // logic to keep track of wrong letters so they don't lose points

    public boolean isWrongBefore() {
        for (int i = 0; i < getPrevioudWrongGuesses().size() ; i++) {
            if (getCharInput() == previousWrongGuesses.get(i)) {
                return true;
            }
        }
        //guessing the same char twice -> if user's input isn't in the city -> store
        return false;
    }

    public boolean isOver(){
        if (! getCurrentGuess().toString().contains("_")){
            return true;
        }
        else if(getPrevioudWrongGuesses().size() == 10){
            return true;
        }
        return false;
    }
}















