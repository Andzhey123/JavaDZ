package DZ1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = iScanner.nextInt();
        int sum = 0;
        int fact = 1;
        for (int i = 0; i <= n; i++) {
            sum+=i;
        }
        System.out.printf("сумма чисел от 1 до %d = %d \n",n,sum);
        if (n==1) 
            fact = 1;
        else {
            for (int j = 2; j<=n; j++) {
                fact*=j;
            }
        }
        System.out.printf("произведение чисел от 1 до %d = %d \n",n,fact);
        iScanner.close();
    }
}
