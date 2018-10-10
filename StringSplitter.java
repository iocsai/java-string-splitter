package stringsplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Generate a string (at least 10 characters long) of random digits(0-9) and letters(A-Z).
 * Then split it equally in half.
 * If the string's length is odd, take the middle character and do the following ways:
 * If it's a digit in the lower half (0-4), put it on the left split string. 
 * Otherwise, put it on the right half. 
 * Do the same thing if it's a letter. 
 * Lower half: (A-M) Upper half: (N-Z)
 * Continue on splitting the strings until every string only has 1 character.
 * Sample:  "AC2Z34NKOP" 
 * Output:  "AC2Z34NKOP" 
 *          "AC2Z3", "4NKOP" 
 *          "AC2", "Z3", "4NK", "OP" 
 *          "AC", "2", "Z", "3", "4", "NK", "O", "P" 
 *          "A", "C", "2","Z", "3", "4", "N", "K", "O", "P"
 * 
 * Built-in split functions are not allowed.
 * 
 * @author Steve
 */
public class StringSplitter {
    
    private final int randomStrLen;
    private final String randomStr;
    private final List<String> output;

    public StringSplitter(int number) {
        this.randomStrLen = number;
        this.output = new ArrayList<>();
        this.randomStr = stringRandomizer(number);
        this.output.add(randomStr);
    }
    
    public static void main(String[] args) {
        StringSplitter ss = new StringSplitter(input());
        ss.split();
        System.out.println(ss.output);
    }
    
    private static int input() {
        int number = 0;
        while (number < 10) {
            System.out.print("Enter a number at least 10: ");
            try {
                String nextLine = new Scanner(System.in).nextLine();
                number = Integer.parseInt(nextLine);
            } catch(NumberFormatException e) {
                System.err.println(e);
                System.out.println("You have to enter a positive whole number!");
            }
        }
        return number;
    }

    private String stringRandomizer(int number) {
        String result = "";
        for (int i = 0; i < number; i++) {
            int randomNum = (int) (Math.random() * 36);
            if (randomNum < 10) {
                result += randomNum;
            } else {
                result += (char) (randomNum + 55);
            }
        }
        return result;
    }

    private void split() {
        for (int i = 0; i < (int) Math.sqrt(randomStrLen) + 1; i++){
            System.out.println(this.output);
            List<String> elements = new ArrayList<>();
            for (int j = 0; j < this.output.size(); j++) {
                elements.add(this.output.get(j));
            }
            this.output.clear();
            elements.forEach((elem) -> {
                if (elem.length() == 1) {
                    this.output.add(elem);
                } else {
                    int half = elem.length() / 2;
                    String firstPart = "";
                    String lastPart = "";
                    for (int k = 0; k < half; k++) {
                        firstPart += elem.charAt(k);
                        lastPart = elem.charAt(elem.length() - 1 - k) + lastPart;
                    }
                    if (elem.length() % 2 == 1 ) {
                        if ((elem.charAt(half) < '5'
                                || (elem.charAt(half) > 'A' && elem.charAt(half) < 'N'))) {
                            firstPart += elem.charAt(half);
                        } else {
                            lastPart = elem.charAt(half) + lastPart;
                        }
                    }
                    this.output.add(firstPart);
                    this.output.add(lastPart);
                }
            });
        }
    }
}
