package MiniProject;


import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // start of the game
        Question q1 = new Question();
        System.out.println(q1.loadFile());
        System.out.println(q1.pickCity());

        q1.displayQuestion();
        q1.isInQuestion();
        q1.displayGuess();

        while (!q1.isOver()) {
            int wrongCount = q1.getPrevioudWrongGuesses().size();
            if (q1.isInQuestion()) {
                q1.displayGuess();
                System.out.println("You are guessing: " + q1.getCurrentGuess());
                System.out.println("You have guessed (" + wrongCount + ") wrong letters.");

                if (!q1.getCurrentGuess().toString().contains("_")) {
                    System.out.println("You win!\nYou have guessed '" + q1.getQuestion() + "' correctly");
                    System.exit(0);
                }

            } else if (!q1.isWrongBefore()) {
                //previously did not get same wrong char
                q1.getPrevioudWrongGuesses().add(q1.getInput());

                if (wrongCount < 10) {
                    System.out.println(q1.getPrevioudWrongGuesses());
                    System.out.println("You are guessing: " + q1.getCurrentGuess());
                    System.out.println("You have guessed (" + wrongCount + ") wrong letters.");
                }

                if (wrongCount == 10) {
                    System.out.println("You lose!\nThe correct word was '" + q1.getQuestion() + "' !");
                    System.exit(0);
                }
//                    q1.getPrevioudWrongGuesses().add(q1.getInput());
//                    System.out.println("You are guessing: " + q1.getCurrentGuess());
//                    System.out.println("You have guessed (" + wrongCount + ") wrong letters.");
//            }
            }
            System.out.println(q1.getPrevioudWrongGuesses());
            System.out.println("You are guessing: " + q1.getCurrentGuess());
            System.out.println("You have guessed (" + wrongCount + ") wrong letters.");

        }
    }
}

