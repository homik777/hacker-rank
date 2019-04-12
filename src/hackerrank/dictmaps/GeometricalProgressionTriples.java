package hackerrank.dictmaps;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class GeometricalProgressionTriples {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        AtomicLong count = new AtomicLong();
        Map<Long, Long> cache = new HashMap<>();
        Set<Long> simpleLongSet = new TreeSet<>();
        for (Long x : arr) {
            cache.merge(x, 1L, (a, b) -> a + b);
            simpleLongSet.add(x);
        }

        if(r == 1L){
            System.out.println(Long.MAX_VALUE);
            System.out.println(factorial(cache.get(1L)));
            simpleLongSet.forEach(a -> count.addAndGet(factorial(cache.get(a)) / (factorial(3L) * factorial(cache.get(a) - 3))));
            return count.get();
        }

        Long[] triples = new Long[3];
        for (long x : simpleLongSet) {
            Long q1 = x * r;
            Long q2 = x * r * r;
            triples[0] = cache.get(x);
            triples[1] = cache.getOrDefault(q1, 0L);
            triples[2] = cache.getOrDefault(q2, 0L);
            if(triples[1] == 0 || triples[2] == 0){
                continue;
            }
            count.addAndGet(factorial(triples[0]) * factorial(triples[1]) * factorial(triples[2]));
        }
        return count.get();
    }

    public static Long factorial(Long a) {
        final Long[] start = {1L};
        LongStream.range(1L, a).boxed().forEach(r -> start[0] = r*a);
        return start[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


