package hackerrank.codesprint.moodys;

public class Partition {

    static int count = 0;

    private static void partition(int n, int length) {
        partition(n, n, "", length);
    }
    private static void partition(int n, int max, String prefix, int length) {
        if (n == 0) {
            //System.out.println(prefix);
            //if((prefix.split(" ").length - 1) <= length)
                count ++;
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            //if(!prefix.contains(String.valueOf(i))) {
                partition(n-i, i, prefix + " " + i, length);
            //}
        }
    }


    public static void main(String[] args) {
        int n = 6;
        partition(100, 100);
        System.out.println(" Count : " + count);
    }
}
