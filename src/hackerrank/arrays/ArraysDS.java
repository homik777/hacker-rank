package hackerrank.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArraysDS {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] mask = {{1,1,1},{0,1,0},{1,1,1}};
        int max = -1;
        for(int x = 0 ; x < arr.length - mask.length + 1; ++x){
            for( int y = 0; y < arr[x].length - mask[0].length; ++y){
                int temp = count(arr, mask, x, y);
                if(max < temp){
                    max = temp;
                }
            }
        }
        return max;
    }

    static int count(int [][]arr, int mask[][], int startRow, int sartColumn){
        int sum = 0;
        for(int x = 0 ; x < mask.length; ++x){
            for( int y = 0; y < mask[x].length; ++y){
                if(mask[x][y]==1){
                        sum+=mask[x+startRow][y+sartColumn];
                }
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int[][] arr = new int[6][6];

            for (int i = 0; i < 6; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 6; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;
                }
            }

            int result = hourglassSum(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
