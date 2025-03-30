package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public static int square(int[][] coords) {
        // [[x1,y1],[x2,y2], ... ]
        int square = 0;
        int len = coords.length;
        for (int i = 0; i < len; i++) {
            square += coords[i][0] * coords[(i + 1) % len][1] - coords[(i + 1) % len][0] * coords[i][1];
        }
        return Math.abs(square / 2);
    }
    public static int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }


    public static int solveReccurence(double a, double b, double c, int n) {
        double discriminant = b * b - 4 * a * c;

        if (Math.abs(discriminant) < Math.pow(10, -8)) {
            double x = -b / (2 * a);

            return (int) Math.round(n * Math.pow(x, n - 1));
        }else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double C1 = -1 / (x2 - x1);
            double C2 = -C1;
            return (int) Math.round(C1 * Math.pow(x1, n) + C2 * Math.pow(x2, n));
        } else{
            return -1;
        }


    }

    public static int[][] mult(int[][] a, int[][] b) {
        int size1 = a.length;
        int size2 = b[0].length;
        if (a[0].length != b.length){
            throw new IllegalArgumentException("Умножение выполнить невозмонжно");
        }
        int[][] result = new int[size1][size2];

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] E(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    public static int[][] power(int[][] matrix, int n) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }
        if (n == 0) {
            return E(matrix.length); // A^0 = I
        }
        if (n == 1) {
            return matrix;
        } else if (n % 2 == 0) {
            int[][] temp = power(matrix, n / 2);
            return mult(temp, temp);
        }
        else {
            int[][] temp = power(matrix, n - 1);
            return mult(temp, matrix);
        }
    }



}
