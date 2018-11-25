package hackerrank.codesprint.moodys;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.stream.Collectors;

public class MeanNormalisation {

    private static List<Double> lstRunningTimes = new ArrayList<>();
    private static List<Double> lstMeansOfStocks = new ArrayList<>();
    private static Map<Integer, List<Integer>> mapStockPrices = new HashMap<>();

    static void collectMeansOfStocks(int[] p_i, int a0) {
        double sumOfStockPrices = 0.0;
        double mean;

        //mapStockPrices.put(a0, Arrays.stream(p_i).boxed().collect(Collectors.toList()));

        for(int i = 0; i < p_i.length; i++) {
            sumOfStockPrices = sumOfStockPrices + p_i[i];
        }
        mean = sumOfStockPrices/p_i.length;
        System.out.println(mean);
        lstMeansOfStocks.add(mean);
    }

    private static double findMinimumRunningTime(ArrayList<Integer> lstPrices) {

        //double temp = 0.0;
        //double temp2;

        lstRunningTimes = lstMeansOfStocks.parallelStream()
                .mapToDouble(x -> lstPrices.parallelStream().mapToDouble(price_i -> Math.abs(x - price_i)).sum())
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(lstRunningTimes);
        return lstRunningTimes.get(0);

        /*System.out.println();

        for (double x : lstMeansOfStocks) {
            *//*for(int eachStock : mapStockPrices.keySet()) {
                *//**//*for(int price_i: mapStockPrices.get(eachStock)) {
                    temp = temp + Math.abs(x - price_i);
                }*//**//*

                temp = temp + mapStockPrices.get(eachStock).parallelStream().collect(Collectors.summingDouble(price_i -> Math.abs(x - price_i)));
            }*//*
            temp = temp + lstPrices.parallelStream().collect(Collectors.summingDouble(price_i -> Math.abs(x - price_i)));

            lstRunningTimes.add(temp);
        }*/

    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.000000");
        ArrayList<Integer> temp;
        ArrayList<Integer> allPrices = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int m_i = in.nextInt();
            int[] p_i = new int[m_i];
            for(int p_i_i = 0; p_i_i < m_i; p_i_i++){
                p_i[p_i_i] = in.nextInt();
            }
            collectMeansOfStocks(p_i, a0);
            temp = (ArrayList<Integer>) Arrays.stream(p_i).boxed().collect(Collectors.toList());
            //Collections.addAll(allPrices, new ArrayList<>(Arrays.stream(p_i).boxed().collect(Collectors.toList())));
            allPrices.addAll(temp);

        }
        System.out.println(df.format(findMinimumRunningTime(allPrices)));
        in.close();
    }
}
