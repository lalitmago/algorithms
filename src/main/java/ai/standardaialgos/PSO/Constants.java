package ai.standardaialgos.PSO;

public class Constants {

    /*private Constants() {

    }

    public final static int NUM_DIMENSIONS = 2;
    public final static int NUM_PARTICLES = 5;
    public final static double MIN = -10;
    public final static double MAX = 10;
    public final static int MAX_ITERATIONS = 10000;
    public final static double w = 0.729;
    public final static double c1 = 1.49445;
    public final static double c2 = 1.49445;

    public static double function(double[] data) {
        //return Math.exp(-data[0]  * data[0] - data[1] * data[1] * Math.sin(data[0]));
        return Math.exp((data[0]*data[0] + data[1]*data[1]));
    }*/

    private Constants() {

    }

    final static int NUM_DIMENSIONS = 2;
    final static int NUM_PARTICLES = 10;
    final static int MAX_ITERATIONS = 10000;
    final static double MIN = -2.0;
    final static double MAX = 2.0;
    final static double w = 0.729; // inertia weight
    final static double c1 = 1.49445; // cognitive/local weight
    final static double c2 = 1.49445; // social/global weight

    static double function(double[] data) {
        //return Math.exp((data[0]*data[0] + data[1]*data[1]));
        return Math.exp(-(data[0] * data[0]) - (data[1] * data[1]) * Math.sin(data[0]));
    }

}
