package DZ1;

import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = iScanner.nextInt();
        System.out.println("Введите второе число: ");
        int b = iScanner.nextInt();
        System.out.println("Введите операцию + - / *: ");
        char op;
        op = iScanner.next().charAt(0);
        int res;


        switch (op) {
            case '+':
                res = a + b;
                System.out.printf("Result: %d",res);
                break;
            case '-':
                res = a - b;
                System.out.printf("Result: %d",res);
                break;
            case '/':
                res = a / b;
                System.out.printf("Result: %d",res);
                break;
            case '*':
                res = a * b;
                System.out.printf("Result: %d",res);
                break;

        }
        iScanner.close();
    }
}
