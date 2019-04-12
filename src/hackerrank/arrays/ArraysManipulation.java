package hackerrank.arrays;

import java.io.*;
import java.util.*;

public class ArraysManipulation {
    public static int max = 0;
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long [] arr = new long[n];

    for (int[] row:queries) {
            put(arr, row[0] - 1, row[1] - 1, row[2]);
        }
        int temp = 0;
        for(int x = 0; x < arr.length-1; ++x){
             temp += arr[x];
            max = Math.max(temp, max);

        }
        return max;
    }


    private static void put(long[] arr, int from, int to, int what) {
        System.out.println(arr[from]+"xf");
        String x = "X";
        arr[from] += what;
        if(arr.length - 1 >= to +1){
            arr[to +1] -= what;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] queries = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }

            long result = arrayManipulation(n, queries);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
