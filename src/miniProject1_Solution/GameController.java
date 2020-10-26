package MiniProject1_Solution;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  The {@code GameController} class represents an instance of a controller for this game.
 *  This class manages all the game related logic.
 *
 * @author Derrick Park
 * @version 1.0
 */

public class GameController {
        // --- data field-----
        // Default values for the number of questions and guesses
        private static final int NUM_QUESTIONS = 100;
        private static final int NUM_GUESSES = 10;
        // instance variable
        private int guesses;
        private Question[] questions;
        private String wrongLetters;
        private boolean isCorrect;

        // ---default constructor----
    public GameController(String filename){
        this.guesses = NUM_GUESSES;
        this.questions = new Question[NUM_QUESTIONS];
        loadQuestions(filename);
        this.wrongLetters = "";
        this.isCorrect = false;
    }

    // ----method field--------
    // load questions from specified filename path into questions.
    private void loadQuestions(String filename){
        try{
            File file = new File(filename);
            Scanner in = new Scanner(file);
            int i = 0;
            while (in.hasNextLine()){
                String line = in.nextLine();
                questions[i++] = new Question(line);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
    }

    // get random question from the questions array
    private Question getRandomQuestion(){
        int index = (int) (Math.random() * 1);
        return questions[index];
    }

    /**
     * Game logic for one question.
     *
     * This method picks a random question from 'questions' and
     * interact with user to finish the game
     */
    // call methods on this class
    public void playGame() throws IllegalArgumentException{
        Question question = getRandomQuestion();
        System.out.println("Here's the question.");
        System.out.println(question.getHint()); // method from Question class
        Scanner in = new Scanner(System.in);
        while (guesses > 0){
            try{
                System.out.println("Guess a letter: ");
                String letter = in.nextLine();
                String prevHint = question.getHint();               // local variable
                String newHint = question.updateHint(letter.toLowerCase()); // local variable
                if (question.isCorrect()){
                    isCorrect = true;
                    break;
                }
                if (prevHint.equals(newHint)){
                    wrongLetters += letter + " ";
                    guesses--;
                }
                System.out.println("You are guessing: " + newHint);
                System.out.println("You have guessed (" + (NUM_GUESSES - guesses) + ") wrong letters: " + wrongLetters);
            } catch (IllegalArgumentException e){
                System.out.println("You must enter one letter!");
            }
        }
        //// Capitalize
        String capitalized = question.getName().substring(0, 1).toUpperCase() + question.getName().substring(1);
        displayResult(isCorrect, capitalized);
    }

    // Displays the result of the game.
    private void displayResult(boolean isCorrect, String question){
        if (isCorrect){
            System.out.println("You win!");
            System.out.println("You have guessed '" + question + "' correctly.");
        } else{
            System.out.println("You lose!");
            System.out.println("The correct word was '" + question + "'");
        }
    }
}
