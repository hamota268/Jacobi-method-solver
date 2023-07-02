/*
created by Youssef Mohamed @ computer science
*/

import java.util.Arrays;
import java.util.Scanner;

public class JacobiMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of variables: ");
        int n = scanner.nextInt();

        double[][] coefficients = new double[n][n];
        double[] constants = new double[n];

        System.out.println("Enter the coefficient matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coefficients[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter the constants array:");
        for (int i = 0; i < n; i++) {
            constants[i] = scanner.nextDouble();
        }

        System.out.print("Enter the number of iterations: ");
        int iterations = scanner.nextInt();

        scanner.close();

        double[] solution = solveEquations(coefficients, constants, iterations);

        System.out.println("Solution:");
        System.out.println(Arrays.toString(solution));
    }

    public static double[] solveEquations(double[][] coefficients, double[] constants, int iterations) {
        int n = coefficients.length;
        double[] solution = new double[n];
        double[] previousSolution = new double[n];

        // Perform Jacobi iterations
        for (int k = 0; k < iterations; k++) {
            // Store the previous solution
            System.arraycopy(solution, 0, previousSolution, 0, n);

            // Compute the new solution for each variable
            for (int i = 0; i < n; i++) {
                double sum = constants[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= coefficients[i][j] * previousSolution[j];
                    }
                }
                solution[i] = sum / coefficients[i][i];
            }
        }

        return solution;
    }
}
