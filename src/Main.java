import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int max = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int n = scanner.nextInt();

        WorkedThread[] threads = new WorkedThread[n];
        int[][] arr = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                arr[i][j] = r.nextInt(5000);

        for (int i = 0; i < n; i++) {
            threads[i] = new WorkedThread(arr[i]);
            threads[i].start();
        }


        try {
            for (int i = 0; i < n; i++) {
                threads[i].join();
                System.out.println("Max element in row " + i + ": " + threads[i].getMax());
                max = Math.max(max, threads[i].getMax());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Matrix: ");
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");

            }
            System.out.println();
        }
        System.out.println("Maximum value was " + max);
    }

}