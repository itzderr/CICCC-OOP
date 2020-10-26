package MiniProject;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Question q1 = new Question();
        q1.loadFile();
        q1.pickCity();
        q1.displayQuestion();  // shows all underscore bar

        while (!q1.isOver()) {
            if (q1.isInQuestion()) {    // input char if in question
                if (q1.displayGuess().toString().contains("_")){
                    System.out.println("You are guessing: " + q1.displayGuess());
                    System.out.println("You have guessed (" + q1.getPreviousWrongGuesses().size() + ") wrong letters.");
                }
                else {
                    System.out.println("You win!\nYou have guessed '" + q1.getQuestion() + "' correctly");
                    System.exit(0);
                }
            } else if (q1.isWrongBefore()){
                    if (q1.getPreviousWrongGuesses().size() == 10){
                        System.out.println("You lose!\nThe correct word was '" + q1.getQuestion() + "' !");
                        System.exit(0);
                    }
                    else {
                        System.out.println("You are guessing: " + q1.getCurrentGuess());
                        System.out.println("You have guessed (" + q1.getPreviousWrongGuesses().size() + ") wrong letters.");
                    }
            } else {
                    q1.getPreviousWrongGuesses().add(q1.getCharInput());            //以前間違えてなければそのcharを追加
                    if (q1.getPreviousWrongGuesses().size() < 10){
                        System.out.println("You are guessing: " + q1.getCurrentGuess());
                        System.out.println("You have guessed (" + q1.getPreviousWrongGuesses().size() + ") wrong letters.");
                    } else {
                        System.out.println("You have guessed (" + q1.getPreviousWrongGuesses().size() + ") wrong letters: " + q1.getPreviousWrongGuesses());
                        System.out.println("You lose!\nThe correct word was '" + q1.getQuestion() + "' !");
                        System.exit(0);
                    }
            }
        }
    }
}


