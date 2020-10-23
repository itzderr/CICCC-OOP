package week2.arrays;

public class BasicArrays2 {

    public static void main(String[] args) {
        int max = 100;
        int min = 1;
        int[] arr = new int[10];
        for (int i = 0; i < arr.length ; i++){
            double random_double = Math.random() * (max - min + 1) + min;
            int random_int = (int)Math.round(random_double);
            arr[i] = random_int;
            System.out.println("Slot " + i + " contains a " + arr[i] );
        }
    }
}
