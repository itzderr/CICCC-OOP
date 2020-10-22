package miniproject1;

public class Driver {
    public static void main(String[] args) {
        GameController controller = new GameController("src/miniproject1/city.txt");
        controller.playGame();
    }
    // Mexico City
    // ___i__ _i__   (updates both i)
    // invalid input: asdf - more than one letter (won't count)
    // wrong char: * (add to wrong letter count)
    // same answer char:  (won't count, ask again)
    // wrong same char : (add to wrong letter count)
}
