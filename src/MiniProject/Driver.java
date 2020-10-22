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

        while(!q1.isOver()) {
            if (q1.isInQuestion()) {
                q1.displayGuess();

                if(!q1.getCurrentGuess().toString().contains("_")){
                    System.out.println("You win! \n You have guessed '" + q1.getQuestion() + "' correctly");
                    System.exit(0);
                }
                else {
                    System.out.println("You are guessing: " + q1.getCurrentGuess());
                }

            } else if (!q1.isWrongBefore()) {
                int wrongCount = q1.getPrevioudWrongGuesses().size();
                if (wrongCount == 10){
                    System.out.println("You lose! \n The correct word was '" + q1.getQuestion() + "' !");
                }
                System.out.println("You have guessed (" + wrongCount + ") wrong letters.");
                System.exit(0);
            }
        }



//        while(!q1.isOver()) {
//            q1.displayQuestion();
//            q1.isInQuestion();
//            q1.displayGuess();
//            if (q1.isInQuestion()) {
//                q1.displayGuess();
//                System.out.println("You are guessing: " + q1.getCurrentGuess() );
//            } else if(! q1.isWrongBefore()){
//                int wrongCount = q1.getPrevioudWrongGuesses().size();
//                System.out.println("You have guessed (" + wrongCount + ") letters." );
//            }

        }



}


