package MiniProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Question {
    // data field
    private ArrayList<String> questions = new ArrayList<>();  // put all the cities in the arraylist
    private String question; // randomly chosen question
    //    private char[] charQuestion; // char array after chosen question in string converted
    private ArrayList<String> previousCorrectGuesses = new ArrayList<String>(); // Store user input (correct)
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
            currentGuess.replace(i, i + 1, "_");
        }
        System.out.println(currentGuess);
    }

    // take user's input
//    public void takeInput(){
//        System.out.print("Guess a letter: ");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        //convert user input from string to char
//        char charInput = input.charAt(0);
//
//        System.out.println("Your guess: " + input);
//
//        // convert selected question into an char array
//        char[] charQuestion = new char[question.length()];
//
//        // loop through each char of the selected string and compare the i position of
//        for (int i = 0; i < question.length(); i++){
//            charQuestion[i] = question.charAt(i);
//        }
//
//        System.out.println(charQuestion);
//        System.out.println(charQuestion[0]);
//
//        for (int j = 0; j < question.length(); j++){
//            if(charInput == charQuestion[j]){
//                System.out.println(getCurrentGuess());
//                currentGuess.replace(j, j+1, input);
//                System.out.println(currentGuess);
//            }
//            else if(getPreviousCorrectGuesses().size() < 10)
//            previousWrongGuesses.add(charInput);
//            else{
//
//            }
//
//        }

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
        if (getQuestion().indexOf(charInput) == -1) {
            previousWrongGuesses.add(charInput);
            return false;
        } else {
            return true;
        }
    }

    // reveal correct letters and display (-> string)
    public void displayGuess() {
        for (int i = 0; i < question.length(); i++) {
            if (question.charAt(i) == getCharInput()) {
                currentGuess.replace(i, i + 1, getInput());
            }
        }
        System.out.println(currentGuess);
    }
}




    // logic to keep track of wrong letters so they don't lose points
        //guessing the same char twice -> if user's input isn't in the city -> store
        // the char to the previousWrongGuess -> return previousWrongGuess

    // check if game over or not (size of previousWrongGuess is less than 10)


    // underscoreがなくなったら-> won!













