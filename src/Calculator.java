import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1 = 0, number2 = 0;
    static char operation;
    static int result;
    static int count = 0;
    static String resultString = null;

    private static int calc(int a, int b, char operation) {
        if (operation == '+') return a + b;
        else if (operation == '-') return a - b;
        else if (operation == '*') return a * b;
        else if (operation == '/') {
            if (a > 0) return a / b;
            else throw new ArithmeticException();
        }
        return -1;
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[numArabian];
        return s;
    }

    private static int romeToNumber(String name) {
        if (name.equals("I")) return 1;
        else if (name.equals("II")) return 2;
        else if (name.equals("III")) return 3;
        else if (name.equals("IV")) return 4;
        else if (name.equals("V")) return 5;
        else if (name.equals("VI")) return 6;
        else if (name.equals("VII")) return 7;
        else if (name.equals("VIII")) return 8;
        else if (name.equals("IX")) return 9;
        else if (name.equals("X")) return 10;

        return -1;
    }

    public static String calca(String stroka) {
        char[] array = new char[stroka.length()];
        for (int i = 0; i < stroka.length(); i++) {
            array[i] = stroka.charAt(i);
            if (array[i] == '+') {
                if (count > 0) throw new ArithmeticException();
                count++;
                operation = '+';
            }
            if (array[i] == '-') {
                if (count > 0) throw new ArithmeticException();
                count++;
                operation = '-';
            }
            if (array[i] == '/') {
                if (count > 0) throw new ArithmeticException();
                count++;
                operation = '/';
            }
            if (array[i] == '*') {
                if (count > 0) throw new ArithmeticException();
                count++;
                operation = '*';
            }
        }
        String text = String.valueOf(array);
        text = text.replaceAll("\\s+", "");
        if (count == 0) throw new InputMismatchException();
        String[] textArray = text.split("[+-/*]");
        String a = textArray[0];
        String b = textArray[1];
        number1 = romeToNumber(a);
        number2 = romeToNumber(b);
        if (number1 < 0 && number2 < 0) {
//           Арабские числа
            number1 = Integer.parseInt(a);
            number2 = Integer.parseInt(b);
            if (number1 < 1 || number1 > 10 && number2 < 1 || number2 > 10) {
                throw new InputMismatchException();
            } else {
                resultString = String.valueOf(calc(number1, number2, operation));
            }

        }
//        Римские Числа
        else if (number1 < 0 || number2 < 0) {
            throw new InputMismatchException();
        } else {
            result = calc(number1, number2, operation);
            if (result < 1) {
                throw new ArithmeticException();
            } else {
                resultString = convertNumToRoman(result);
            }
        }
        return resultString;
    }

    public static void main(String[] args) {
        String input = scanner.nextLine();
        System.out.println(calca(input));
    }
}
