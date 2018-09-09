package academy.mate.homeworks.hw1;

import java.util.ArrayList;
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
            ArrayList<int[]> range = ranges(inputArray);
            for (int[] ints : range) {
                System.out.print(Arrays.toString(ints));
            }
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

    //TODO: without ArrayList
    //TODO: without second for
    private static ArrayList<int[]> ranges(int[] inputArray) {
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < inputArray.length - 1; i++) {
            int[] tempArray = new int[2];
            if (inputArray[i + 1] - inputArray[i] != 1) {
                result.add(new int[]{inputArray[i]});
            } else {
                tempArray[0] = inputArray[i];
                for (int j = i; j < inputArray.length - 1; j++) {
                    if (inputArray[i + 1] - inputArray[i] != 1) {
                        break;
                    }
                    tempArray[1] = inputArray[j];
                    i = j;
                }
                result.add(tempArray);
            }
        }
        return result;
    }

    private static int[] createRandomArray(int arrayLength) { //For lazy dudes
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            Random random = new Random();
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
