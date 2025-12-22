package Day7;

import java.util.PriorityQueue;

public class PriorityQueueIntro {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(5);
        pq.offer(1);
        pq.offer(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
