package hackerrank;
import java.io.*;
import java.util.*;

public class MergeSortInversion {

//    static InvertionCounter counter = new InvertionCounter();

    static class InvertionCounter{
        private long counter = 0;
        private int[] org;
        private int[] copy;

        public InvertionCounter(int[] org) {
            this.org = org;
            this.copy = new int[org.length];
            System.arraycopy(org, 0, copy, 0, org.length);
        }

        public long process(int low, int high){
            if(low == high) return 0L;
            int mid = low + (high - low)/2;

            long count =0;
            count += process(low, mid);
            count += process(mid + 1, high);
            count += processMerge(low, mid, high);

            return count;
        }

        private long processMerge(int low, int mid, int high) {
            long count = 0;
            int i = low;
            int j = mid +1;
            int k = low;
            while(i <= low || j <= high){
                if(i > mid){
                    org[k++] = copy[j++];
                }else if(j > high){
                    org[k++] = copy[j++];
                }else if(copy[i] <= copy[j]){
                    org[k++] = copy[i++];
                }else{
                    org[k++] = copy[j++];
                    count += mid - i + 1;
                }
            }
            System.arraycopy(org, 0, copy, 0, org.length);
            return count;

        }


    }

    static long countInversions(int[] arr) {
        InvertionCounter counter = new InvertionCounter(arr);
        return counter.process(0, arr.length - 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] arr = new int[n];

                String[] arrItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int arrItem = Integer.parseInt(arrItems[i]);
                    arr[i] = arrItem;
                }

                long result = countInversions(arr);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
        }
        scanner.close();
    }
}
