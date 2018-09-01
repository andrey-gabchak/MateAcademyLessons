package academy.mate.homeworks.hw1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose task");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int arrayLength = scanner.nextInt();
        System.out.println("Enter 'k' step: ");
        int k = scanner.nextInt();

        //TODO:choosing task

        int[] array = createRandomArray(arrayLength);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayRotation(array, k)));

        int[] arrayMono = {1, 2, -1, 4, 7, 6, -2, 4}; //TODO: delete the shitcode
        System.out.println(Arrays.toString(restoreArray(arrayMono)));

        int[] arrayRange = {1, 2, 3, 5, 8, 9, 10, 13, 14, 15, 16};
        ArrayList<int[]> range = ranges(arrayRange);
        for (int[] ints : range) {
            System.out.print(Arrays.toString(ints));
        }
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

    private static int[] restoreArray(int[] inputArray) {
        int[] result = inputArray;
        for (int i = 1; i < result.length - 1; i++) { //Negative elements (NE) can be ONLY INSIDE monotone part. So NE can't be first and last position.
            if (result[i] < 0) {
                result[i] = result[i - 1] / 2 + result[i + 1] / 2;
            }
        }
        return result;
    }

    private static ArrayList<int []> ranges(int [] inputArray) {
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < inputArray.length - 1; i++) {
            int [] tempArray = new int[2];
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
}
