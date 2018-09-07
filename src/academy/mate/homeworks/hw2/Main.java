package academy.mate.homeworks.hw2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char inputChar = scanner.next().charAt(0);
        String inputString = scanner.next();
        Main main = new Main();
//        System.out.println(main.isPalindrome(inputString) ? "Is Main" : "Isn't palindrome");
//        System.out.println(main.stringPartReverse(inputString, 2, 4));
        System.out.println(main.frequencyOfChar(inputChar, inputString));
    }

    private boolean isPalindrome(String inputString) {
        String reverse = stringPartReverse(inputString, 0, inputString.length() - 1);
        return reverse.equalsIgnoreCase(inputString);
    }

    private String stringPartReverse(String inputString, int indexFrom, int indexTo) {
        char[] charArray = inputString.toCharArray();
        for (int i = indexFrom; i < indexTo; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[indexTo - i];
            charArray[indexTo - i] = temp;
        }
        return String.copyValueOf(charArray);
    }

    private int frequencyOfChar( char ch, String str) {
        char[] inputChars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] == ch) {
                count++;
            }
        }
        return count;
    }

}
