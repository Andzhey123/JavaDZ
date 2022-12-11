package DZ4;

import java.util.LinkedList;

public class task3 {
    public static void main(String[] args) {
        Object[] arr = {2, 6, "wasd", 19, "zxcv"};
        AddToStack(arr);
        AddToQueue(arr);
    }

    public static void AddToStack(Object[] obj) {
        LinkedList<Object> stack = new LinkedList<>();
        for (Object object: obj) {
            stack.push(object);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    public static void AddToQueue(Object[] obj) {
        LinkedList<Object> queue = new LinkedList<>();
        for (Object object: obj) {
            queue.offer(object);
        }
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }
}
