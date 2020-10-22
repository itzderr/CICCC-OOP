package MiniProject;


import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // start of the game
        Question q1 = new Question();
        q1.loadFile();
        System.out.println(q1.pickCity());
        q1.displayQuestion();  // shows all underscore bar

        while (!q1.isOver()) {
            int wrongCount = q1.getPrevioudWrongGuesses().size(); // 毎回更新
            if (q1.isInQuestion()) {    // input char if in question
                if (!q1.getCurrentGuess().toString().contains("_")) {     // if there are still unrevealed letter
                    System.out.println("You win!\nYou have guessed '" + q1.getQuestion() + "' correctly");
                    System.exit(0);
                }
                System.out.println("You are guessing: " + q1.displayGuess()); // displayQuestion　q1.getCurrentGuess()
                System.out.println("You have guessed (" + q1.getPrevioudWrongGuesses().size() + ") wrong letters.");


//            } else if (!q1.isWrongBefore()) {
//                //previously did not get same wrong char
//                q1.getPrevioudWrongGuesses().add(q1.getCharInput()); //以前間違えてなければそのcharを追加
//                if (q1.getPrevioudWrongGuesses().size() < 10) {
////                    System.out.println(q1.getPrevioudWrongGuesses());
//                    System.out.println("You are guessing: " + q1.getCurrentGuess());
//                    System.out.println("You have guessed (" + q1.getPrevioudWrongGuesses().size() + ") wrong letters.");
//                }
//
//                if (q1.getPrevioudWrongGuesses().size()== 10) {
//                    System.out.println("You lose!\nThe correct word was '" + q1.getQuestion() + "' !");
//                    System.exit(0);
//                }
//            } else {
//                System.out.println("You are guessing: " + q1.getCurrentGuess());
//                System.out.println("You have guessed (" + q1.getPrevioudWrongGuesses().size() + ") wrong letters.");
//            }
            }else if (q1.isWrongBefore()){
                    System.out.println(q1.getPrevioudWrongGuesses());
                    if (q1.getPrevioudWrongGuesses().size() == 10){
                        System.out.println("You lose!\nThe correct word was '" + q1.getQuestion() + "' !");
                        System.exit(0);
                    }
                    else {
                        System.out.println("You are guessing: " + q1.getCurrentGuess());
                        System.out.println("You have guessed (" + q1.getPrevioudWrongGuesses().size() + ") wrong letters.");
                    }
            } else {
                    q1.getPrevioudWrongGuesses().add(q1.getCharInput()); //以前間違えてなければそのcharを追加
                    if(q1.getPrevioudWrongGuesses().size() < 10){
                        System.out.println(q1.getPrevioudWrongGuesses());
                        System.out.println("You are guessing: " + q1.getCurrentGuess());
                        System.out.println("You have guessed (" + q1.getPrevioudWrongGuesses().size() + ") wrong letters.");
                    } else{
                        System.out.println("You lose!\nThe correct word was '" + q1.getQuestion() + "' !");
                        System.exit(0);
                    }
                }
            }
        }
}


