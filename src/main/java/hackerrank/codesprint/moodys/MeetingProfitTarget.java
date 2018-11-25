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

public class MeetingProfitTarget {

    // Complete the solve function below.
    private static int solve(List<List<Integer>> profits) {
        long unachievedProfit = 0;

        for(int i = 0; i < profits.size(); i++) {
            //System.out.println("Is " + profits.get(i).get(1) + " + " + unachievedProfit + " > " + profits.get(i).get(0));
            if((profits.get(i).get(1) + unachievedProfit) > profits.get(i).get(0))
                unachievedProfit = (profits.get(i).get(1) + unachievedProfit) - profits.get(i).get(0);
            else
                unachievedProfit = 0;
            //System.out.println("Unachieved Profit for this day = " + unachievedProfit);
        }

        if(unachievedProfit > 0)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> profits = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        profits.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int res = solve(profits);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
