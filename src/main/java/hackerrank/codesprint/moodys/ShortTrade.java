package hackerrank.codesprint.moodys;

import java.util.Scanner;

public class ShortTrade {

    private static int count = 0;

    private static int short_trade(int a, int m) {
        /*int x = Integer.MAX_VALUE;
        int count = 0;
        //int pivot = a;

        if ((m == 1) || ((a == 1)||(a == 2) || (a == 0)))
            return 1;
        else {
            while(x >= (a/2 + 1)) {
                x = Integer.max(0, Integer.min(a, x - 1));
                //count++;
                if((x - a) != 0){
                    //System.out.println("Recursion call with {" + (a-x) + ", " + (m - 1) + "}");
                    //System.out.println("Value of count (Before) = " + count);
                    count = count + short_trade(a - x, m - 1);
                    //System.out.println("Value of count (After) = " + count);
                }

            }
        }
        return count;*/
        count = 0;
        return short_trade(a, a, "", m);
    }

    private static int short_trade(int a, int max, String borrowingPattern, int m) {
        if (a == 0) {
            if((borrowingPattern.split(" ").length - 1) <= m)
                count ++;
        }

        for (int i = Math.min(max, a); i >= 1; i--) {
            if(!borrowingPattern.contains(String.valueOf(i))) {
                short_trade(a - i, i, borrowingPattern + " " + i, m);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int m = in.nextInt();
            int x = short_trade(a, m);
            System.out.println(x);
        }
        in.close();
    }
}
