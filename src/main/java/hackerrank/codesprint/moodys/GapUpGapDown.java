package hackerrank.codesprint.moodys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GapUpGapDown {

    private static int solveGapUp (List<Integer> low, List<Integer> close) {

        int noOfDays = close.size();
        int count = 0;

        for(int i = 1; i < noOfDays; i++) {
            if(low.get(i) > close.get(i - 1))
                count++;
        }
        return count;
    }

    private static int solveGapDown (List<Integer> high, List<Integer> close) {

        int noOfDays = close.size();
        int count = 0;

        for(int i = 1; i < noOfDays; i++) {
            if(high.get(i) < close.get(i - 1))
                count++;
        }
        return count;
    }

    private static void solve(List<Integer> low, List<Integer> high, List<Integer> close) {

        System.out.println(solveGapUp(low, close) + " " + solveGapDown(high, close));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> low = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> high = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> close = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        solve(low, high, close);

        bufferedReader.close();
    }
}
