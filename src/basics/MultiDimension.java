package basics;

public class MultiDimension {
    public static void main(String[] args) {
        // Create a two-dimensional array
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // the sum of first row?
        int firstRowSum = data[0][0] + data[0][1] + data[0][2];
        int rowSum = 0;
        for (int i = 0; i < data[0].length; i++) {
            rowSum += data[0][i];
        }
        System.out.println("Row sum: " + rowSum);

        // the sum of first col?
        int firstColSum = data[0][0] + data[1][0] + data[2][0];
        int colSum = 0;
        for (int i = 0; i < data.length; i++) {
            colSum += data[i][0];
        }
        System.out.println("Col sum: " + colSum);

        // create a two dimensional array of strings
        // {{null, X, X, X, X}, {X, X, X, X, X}, {X, X, X, X, X}}
        // empty two dimensional array of row 3, col 5
        String[][] students = new String[3][5];
        students[0][0] = "Shintaro";
        students[0][1] = "Nicolas";
        students[0][3] = "Kideok";
        students[0][4] = "Miriam";
        students[1][0] = "Takayuki";
        students[1][2] = "Adriano";
        students[1][4] = "Yumi";
        students[2][0] = "Kazunobu";
        students[2][2] = "Takayasu";
        students[2][4] = "Danilo";

        // for each row
        //     for each col
        //         print value at row, col
        for (int r = 0; r < students.length; r++) {
            for (int c = 0; c < students[r].length; c++) {
                if (students[r][c] == null) {
                    System.out.print("  X  ");
                } else {
                    System.out.print(students[r][c] + " ");
                }
            }
            System.out.println();
        }
    }
}
