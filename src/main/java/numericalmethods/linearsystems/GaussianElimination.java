package numericalmethods.linearsystems;

public class GaussianElimination {

    //private static final double EPSILON = 0.00001;

    public static void main(String[] args) {
        double[][] matrix = {{1, 5, -2},
                {2, 3, 1},
                {2, 4, -3}};

        double[] vector = {2, 5, 2};

        double[] solution = solve(matrix, vector);

        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    private static double[] solve(double[][] matrix, double[] vector) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            System.out.println("Index i = " + i);

            int max = i;

            for (int j = i + 1; j < N; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[max][i])) {
                    max = j;
                }
            }
            System.out.println("Largest row is : " + matrix[max][0] + ", " + matrix[max][1] + ", " + matrix[max][2]);

            System.out.println("Swap row : " + matrix[i][0] + ", " + matrix[i][1] + ", " + matrix[i][2] + " with largest row : " + matrix[max][0] + ", " + matrix[max][1] + ", " + matrix[max][2]);
            double[] temp = matrix[i];
            matrix[i] = matrix[max];
            matrix[max] = temp;

            double v = vector[i];
            vector[i] = vector[max];
            vector[max] = v;

            for (int k = i + 1; k < N; k++) {
                System.out.println("Pivoting start...");

                double alpha = matrix[k][i] / matrix[i][i];
                System.out.println("alpha = matrix[" + k + "][" + i + "]/matrix[" + i + "][" + i + "] = " + alpha);

                vector[k] -= alpha * vector[i];

                for (int j = i; j < N; j++) {
                    System.out.println("Decrementing matrix[" + k + "][" + j + "] = " + matrix[k][j] + " by alpha (" + alpha + ") * matrix[" + i + "][" + j + "] (" + matrix[i][j] + ") = " + alpha * matrix[i][j]);
                    matrix[k][j] -= alpha * matrix[i][j];
                }

                System.out.println("Pivoting end...");
            }
        }
        showMatrix(matrix, vector);

        double[] x = new double[N];

        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;

            for (int j = i + 1; j < N; j++) {
                sum += matrix[i][j] * x[j];
            }

            x[i] = (vector[i] - sum) / matrix[i][i];
        }
        return x;
    }

    private static void showMatrix(double[][] matrix, double[] vector) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][0] + ", " + matrix[i][1] + ", " + matrix[i][2] + " | " + vector[i]);
        }
    }
}
