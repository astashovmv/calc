import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int num1, num2;
    static char operator;
    static String output;
    static int result;

    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        String str_input = sc.nextLine();
        String calculator = calc(str_input);
        System.out.println("Output:");
        System.out.println(calculator);

    }

    public static String calc(String input) {
        char[] character = new char[10];
        for (int i = 0; i < input.length(); i++) {
            character[i] = input.charAt(i);
            if (character[i] == '+') {
                operator = '+';
            }
            if (character[i] == '-') {
                operator = '-';
            }
            if (character[i] == '*') {
                operator = '*';
            }
            if (character[i] == '/') {
                operator = '/';
            }
        }
        String characterString = String.valueOf(character);
        String[] numbers = characterString.split("[+-/*]");
        try {
            throw new IOException();
        } catch (IOException e) {
            if (numbers.length != 2) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                throw new RuntimeException(e);
            }
        }
        //numbers = input.split(" ");
        String num_rom1 = numbers[0];
        String num_rom2 = numbers[1];
        String num_rom3 = num_rom2.trim();
        num1 = romanToNumber(num_rom1);
        num2 = romanToNumber(num_rom3);


        if (num1 < 0 && num2 < 0) {
            result = 0;
        }else if (num1 == -1 || num2 == -1) {
            System.out.println("Неверный формат ввода.");
        } else {
            result = calculated(num1, num2, operator);
            String resultRoman = convertNumToRoman(result);
            try {
                throw new IOException();
            } catch (IOException e) {
                if (result < 1) {
                    System.out.println("Римские числа могут быть только положительными.");
                    throw new RuntimeException(e);
                }
            }
            output = String.valueOf(resultRoman);
            return output;
        }
        num1 = Integer.parseInt(num_rom1);
        num2 = Integer.parseInt(num_rom3);
        try {
            throw new IOException();                     //NumberFormatException();
        } catch (IOException e) {                        //(NumberFormatException e) {
            if (num1 > 10 || num2 > 10) {
                System.out.println("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
                throw new RuntimeException(e);
            }
        }
        result = calculated(num1, num2, operator);
        output = String.valueOf(result);
        return output;

    }



        public static int calculated (int num1, int num2, char op) {
        int result;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Введен не верный оператор (+, -, /, *).");
                throw new NumberFormatException();

        }
        return result;
    }

    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат ввода.");
        }
        return -1;
    }

    private static String convertNumToRoman(int arabNum) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        final String str = roman[arabNum];
        return str;
        }
    }








