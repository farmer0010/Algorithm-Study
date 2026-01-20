package Day22;

import java.util.Collections;
import java.util.PriorityQueue;

class DualPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if(command.equals("I"))
            {
                minPQ.offer(value);
                maxPQ.offer(value);
            } else if (command.equals("D")) {
                // 장부가 비어있으면 삭제 명령은 무시
                if(maxPQ.isEmpty())
                    continue;
                if(value == 1)
                {
                    int max = maxPQ.poll();
                    minPQ.remove(max);
                }
                else
                {
                    int min = minPQ.poll();
                    maxPQ.remove(min);
                }
            }
        }
        if(minPQ.isEmpty())
            return new int[]{0,0};
        else {
            return new int[]{minPQ.peek(), maxPQ.peek()};
        }
    }
}
