package week2.arrays;

public class LocatingTheLargestValue {
    public static void main(String[] args) {
        int max = 100;
        int min = 1;
        int[] arr = new int[10];
        System.out.print("Array: ");
        for (int i = 0; i < arr.length ; i++){
            double random_double = Math.random() * (max - min + 1) + min;
            int random_int = (int)Math.round(random_double);
            arr[i] = random_int;
            System.out.print(arr[i] + " ");
        }

        // liner search to find the largest
        int max_value = arr[0];
        int slot = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > max_value){
                max_value = arr[i];
                slot = i;
            }
        }
        System.out.println();
        System.out.println("The largest value is " + max_value + "\nIt is in slot " + slot);

    }
}
