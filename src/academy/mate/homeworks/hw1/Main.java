package academy.mate.homeworks.hw1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int arrayLength = scanner.nextInt();
        System.out.println("Enter 'k' step: ");
        int k = scanner.nextInt();

        int[] array = createRandomArray(arrayLength);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayRotation(array, k)));

    }

    private static int[] arrayRotation(int[] array, int k) {
        int[] result = new int[array.length];
        System.arraycopy(array, k, result, 0, array.length - k);
        System.arraycopy(array, 0, result, array.length - k, k);
        return result;
    }

    private static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            Random random = new Random();
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
