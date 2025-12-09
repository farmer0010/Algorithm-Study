package Day2;

import java.util.Deque;
import java.util.LinkedList;

class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> que = new LinkedList<>();

        int[] queSub = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            double days = (double) remain / speeds[i];
            queSub[i] = (int) Math.ceil(days);
        }
        int days = queSub[0];
        int count = 1;
        for (int i = 1; i < queSub.length; i++) {
            if (queSub[i] <= days) {
                count++;
            }
            else {
                que.offer(count);
                count = 1;
                days = queSub[i];
            }
        }
        que.offer(count);
        int[] answer = new int[que.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = que.poll();
        }
        return answer;
    }
}
