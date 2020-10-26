package MiniProject1_Solution;

public class Driver {
    public static void main(String[] args) {
        GameController controller = new GameController("cities.txt");
        controller.playGame();
    }
    // Mexico City
    // __i_ _i_ (updates both i)
    // invalid input: asdf - more than one letter (won't count)
    // wrong char: * (add to wrong letter count)
    // same answer char: (won't count, ask again)
    // wrong same char: (add to wrong letter count)
}
