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
            // 여기서 더블로 캐스팅 이유는 소수점을 살리기 위함
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
                // 여기서 days를 갱신 안하면 이전 반장이 계속 비교대상이 됨
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
