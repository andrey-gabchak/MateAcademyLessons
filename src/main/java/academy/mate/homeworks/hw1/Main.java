package academy.mate.homeworks.hw1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose task");
        System.out.println("Enter 1 to Array Rotation");
        System.out.println("Enter 2 to Restore Array");
        System.out.println("Enter 3 to Ranges");

        Scanner scanner = new Scanner(System.in);

        int variant = scanner.nextInt();

        System.out.print("Enter array length: ");
        int arrayLength = scanner.nextInt();
        System.out.print("Enter arrays value: ");
        int[] inputArray = new int[arrayLength];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = scanner.nextInt();
        }

        if (variant == 1) {
            System.out.println("Enter 'k' step: ");
            int k = scanner.nextInt();
            System.out.println("Input array is " + Arrays.toString(inputArray));
            System.out.println("Result array is " + Arrays.toString(arrayRotation(inputArray, k)));
        }
        if (variant == 2) {
            System.out.println(Arrays.toString(restoreArray(inputArray)));
        }
        if (variant == 3) {
            System.out.println(ranges(inputArray));
        }
    }

    private static int[] arrayRotation(int[] array, int k) {
        int[] result = new int[array.length];
        for (int i = k, j = 0; i < array.length; i++, j++) {
            result[j] = array[i];
        }
        for (int i = 0, j = k + 1; i < k; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }

    private static int[] restoreArray(int[] inputArray) {
        int[] result = inputArray;
        for (int i = 1; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i] = (result[i - 1] + result[i + 1]) / 2;
            }
        }
        return result;
    }

    private static String ranges(int[] inputArray) {
        StringBuilder result = new StringBuilder();
        int lastIterationStep = 0;
        for (int i = lastIterationStep; i < inputArray.length - 1; i++) {
            if (i == lastIterationStep) {
                if (inputArray[i] == inputArray[i + 1] - 1) {
                    result.append('[');
                    result.append(inputArray[i]);
                    result.append(' ');
                } else {
                    result.append('[');
                    result.append(inputArray[lastIterationStep]);
                    result.append(']');
                    lastIterationStep++;
                }
            } else if (i + 1 == inputArray.length - 1) {
                if (inputArray[i] + 1 == inputArray[i + 1]) {
                    result.append(inputArray[i + 1]);
                    result.append(']');
                } else {
                    result.append('[');
                    result.append(inputArray[i + 1]);
                    result.append(']');
                }
            } else {
                if (inputArray[i] + 1 != inputArray[i + 1]) {
                    result.append(inputArray[i]);
                    result.append(']');
                    lastIterationStep = i + 1;
                }
            }
        }
        return result.toString();
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
