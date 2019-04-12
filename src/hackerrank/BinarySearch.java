package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BinarySearch {
//    static class IceCreamFlavorManager{
//        private int[] cost;
//        private int[] result = new int [2];
//        private int money;
//
//        private findFlavorAtCost(int targetCost, int start, int end, int skipIndex){
//            int diff = (end)
//        }
//    }
//
//
//    // Complete the whatFlavors function below.
//    static void whatFlavors(int[] cost, int money) {
//        int [] result = new int[2];
//        int index = 0;
//        for (int flavor : cost){
//            int diff = money - flavor;
//            int secondIndex = findFlavorAtCost(diff, index);
//        }
//    }

//    private static int findFlavorAtCost(int diff, int index, int low, high, int [] arr) {
//        int mid =
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

//            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
