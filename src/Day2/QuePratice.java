package Day2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QuePratice {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);

        int output = queue.poll();
        int peek = queue.peek();
    }
}
