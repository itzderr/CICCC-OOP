package week2.arraylists;

import java.util.ArrayList;

public class LocatingTheLargestValue {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        int max = 100;
        int min = 1;
        for (int i = 0; i < 10; i++){
            double random_double = Math.random() * (max - min + 1) + min;
            int random_int = (int)Math.round(random_double);
            numList.add(random_int);
        }
        System.out.println("ArrayList: " + numList);

        int largest = numList.get(0);
        int slot = 0;
        for (int i = 0; i < numList.size(); i++){
            if (numList.get(i) > largest){
                largest = numList.get(i);
                slot = i;
            }
        }
        System.out.println();
        System.out.println("The largest value is " + largest + ", which is in slot " + slot);
    }
}
