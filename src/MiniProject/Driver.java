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
//        q1.takeInput();


        // Allows for multiplay games
//        boolean isNotCompleted = true;
//        boolean hasPoints = true;
//        While(isNotCompleted && hasPoints){
//            // setting up the game
//
//            while(!game.gameOver()){
//                // play the game
    }
}


