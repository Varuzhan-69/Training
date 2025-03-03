

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {

        if (!input.matches("\\d+[+\\-*/]\\d+")) {
            throw new IllegalArgumentException("Ошибка");
        }
        String operator = "";
        int a = 0, b = 0;
        if (input.contains("+")) {
            operator = "+";
        } else if (input.contains("-")) {
            operator = "-";
        } else if (input.contains("*")) {
            operator = "*";
        } else if (input.contains("/")) {
            operator = "/";
        }
        String[] parts = input.split("[" + operator + "]");
        a = Integer.parseInt(parts[0]);
        b = Integer.parseInt(parts[1]);
        if (a < 0 || a > 9 || b < 0 || b > 9) {
            throw new IllegalArgumentException("Числа от 1 до 10");
        }
        int result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException("Делить на ноль нельзя");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Некорректная операция");
        }


        return String.valueOf(result);

    }
}



