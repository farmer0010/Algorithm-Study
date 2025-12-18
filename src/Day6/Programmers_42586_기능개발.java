package Day6;

// 여기서 핵심은 작업기간이 얼마나 남았는지? 값을 넣어주는게 중요
// 남은 작업일 까지는 생각해서 처리함
// 근데 이제 어떻게 비교하면서 처리할지 생각중

import java.util.Deque;
import java.util.LinkedList;

class Programmers_42586_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new LinkedList<>();
        int[] que = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            double progressesDay = Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            que[i] = (int)progressesDay;
        }
        int days = que[0];
        int count = 1;
        for (int i = 1; i < que.length; i++) {
            if(que[i] <= days)
            {
                count++;
            }
            else
            {
                queue.offer(count);
                count = 1;
                days = que[i];
            }
        }
        queue.offer(count);
        int[] answer = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}
