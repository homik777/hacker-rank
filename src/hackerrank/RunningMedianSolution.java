package hackerrank;

import java.util.*;

public class RunningMedianSolution {
    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    StringJoiner joiner = new StringJoiner("\n");

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        RunningMedianSolution sol = new RunningMedianSolution();
        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            sol.put(aItem);
            sol.balance();
            sol.median();
        }
        sol.print();
        scanner.close();
    }

    private void print() {
        System.out.println(joiner.toString());
    }

    private void median() {
        if (left.size() > right.size()) {
            joiner.add(Double.toString(left.peek()));
        } else if (right.size() > left.size()) {
            joiner.add(Double.toString(right.peek()));
        } else {
            joiner.add(Double.toString((left.peek() + right.peek()) / 2f));
        }
    }

    private void balance() {
        int diff = left.size() - right.size();
        if (diff > 1) {
            right.add(left.poll());
        } else if (diff < -1) {
            left.add(right.poll());
        }
    }

    private void put(int aItem) {
        if (left.peek() == null || left.peek() >= aItem) {
            left.add(aItem);
        } else {
            right.add(aItem);
        }
    }
}
