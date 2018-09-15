package academy.mate.dataStructure.String;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter repeating character: ");
        char inputChar = scanner.next().charAt(0);
        System.out.print("Enter input string: ");
        String inputString = scanner.next();
        Main main = new Main();
        System.out.println(main.isPalindrome(inputString) ? "Is Palindrome" : "Isn't palindrome");
        System.out.println("Reverse string is '" + main.stringPartReverse(inputString, 2, 4) + "'");
        System.out.println("Character " + inputChar + " repeat " + main.frequencyOfChar(inputChar, inputString) + " times");
    }

    private boolean isPalindrome(String inputString) {
        String reverse = stringPartReverse(inputString, 0, inputString.length() - 1);
        char[] inputChars = inputString.toCharArray();
        char[] reverseChars = reverse.toCharArray();
        boolean palindrome = true;
        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] != reverseChars[i]) {
                palindrome = false;
            }
        }
        return palindrome;
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
        for (char inputChar : inputChars) {
            if (inputChar == ch) {
                count++;
            }
        }
        return count;
    }

}
