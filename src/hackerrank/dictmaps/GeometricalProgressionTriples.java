package hackerrank.dictmaps;

import util.PathDefines;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;


public class GeometricalProgressionTriples {

    public static class NumberMetaData{
        private Long number;
        private Long total = 0L;

        NumberMetaData(Long number){
            this.number = number;
        }

        public Long getNumber() {
            return number;
        }

        public Long getTotal() {
            return total;
        }

        public void incTotal() {
            this.total++;
        }

    }
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Long count = 0L;
        Long dontInclude = 0L;
        Map<Long, NumberMetaData> cachedMeta = new HashMap<>();

        for (int i = 0; i < arr.size(); ++i) {
            long a2 = arr.get(i)*r;
            long a3 = a2*r;
            cachedMeta.putIfAbsent(arr.get(i), new NumberMetaData(arr.get(i)));
            cachedMeta.get(arr.get(i)).incTotal();

            if(cachedMeta.containsKey(a2)){
                dontInclude += cachedMeta.get(a2).getTotal();
            }
            if(cachedMeta.containsKey(a3)){
                dontInclude += cachedMeta.get(a3).getTotal();
            }
        }

        if (r == 1L) {
            for (NumberMetaData number : cachedMeta.values()) {
                Long n = number.getTotal();
                count += newtonExpression(n, 3L);
            }

        }else{
            for(NumberMetaData number: cachedMeta.values()){
                Long a2 = number.getNumber() * r;
                Long a3 = a2*r;
                if(cachedMeta.containsKey(a2) && cachedMeta.containsKey(a3)){
                    count += newtonExpression(number.getTotal() ,1L)*newtonExpression(cachedMeta.get(a2).getTotal() ,1L)*newtonExpression(cachedMeta.get(a3).getTotal(),1L);
                    count -= dontInclude;
                }
            }
        }
        return count;
    }

    public static Long newtonExpression(Long n, Long k) {
        Long start = n-(k-1);
        Long result = 1L, temp = 1L;
        for (long i = start; i <= n; ++i) {
            result = result*i;
        }
        for (long i = 1; i <= k; ++i){
            temp = temp*i;
        }
        return result/temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathDefines.OUT_PUT_PATH + File.pathSeparator + "geo_progess.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans + "");
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


