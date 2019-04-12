package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps {

    static int[] copy;
    static int[] org;
    static int result = 0;
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        copy = new int[arr.length];
        org =arr;

        for(int i = 0; i < arr.length; ++i){
            swap(i);
        }
        return result;
    }

    static void swap(int i){
        while(Math.min(org[i] - 1, org.length -1) != i){
            copy[i] = org[Math.min(org[i] - 1, org.length - 1)];
            org[Math.min(org[i] - 1, org.length -1)] = org[i];
            org[i] = copy[i];
            result++;
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int res = minimumSwaps(arr);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
