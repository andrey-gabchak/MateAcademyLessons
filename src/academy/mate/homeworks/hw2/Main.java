package academy.mate.homeworks.hw2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        System.out.println(isPalindrome(inputString) ? "Is Main" : "Isn't palindrome");
        System.out.println(stringPartReverse(inputString, 2, 4));
    }

    private static boolean isPalindrome(String inputString) {
        String reverse = stringPartReverse(inputString, 0, inputString.length() - 1);
        return reverse.equalsIgnoreCase(inputString);
    }

    private static String stringPartReverse(String inputString, int indexFrom, int indexTo) {
        char[] charArray = inputString.toCharArray();
        for (int i = indexFrom; i < indexTo; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[indexTo - i];
            charArray[indexTo - i] = temp;
        }
        return String.copyValueOf(charArray);
    }



}
