package DZ1;

public class task2 {
    public static void main(String[] args) {
        int n =0;
        for (int i=1; i<=1000; i++){
            for (int j=1; j<=i; j++){
                if (i%j==0)
                    n++;
            }if (n==2 || n==1)
                System.out.print(i+ " ");
            n=0;
        }
    }
}
