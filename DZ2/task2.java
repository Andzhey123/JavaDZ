package DZ2;

import java.util.logging.*;
public class task2 {
    public static void sort(int[] arr){
        Logger logger = Logger.getLogger(task1.class.getName());
        logger.setLevel(Level.INFO);
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);        
        for(int i=arr.length-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (arr[j]>arr[j+1]){
                    logger.info("поменяли элемент с индекса " + j + " на индекс " + (j+1));
                    int count = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = count;
                }
            }
        }for (int i=0; i<arr.length;i++){
        System.out.print(arr[i]+ " ");
    }
    }

    public static void main(String[] args) {
        int[] arr = {7,6,3,9,2,4,5,-6};
        sort(arr);
    }
}
