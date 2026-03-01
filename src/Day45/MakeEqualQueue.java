package Day45;

// 길이가 같은 두개의 큐가 있고
// 하나의 큐를 골라 원소를 추출(pop) 하고
// 다른큐에는 집어넣는(insert) 작업을 통해
// 합이 같도록 하려고함
// 리턴값: 이때 필요한 작업의 최소 횟수
// 같게 할수 없을 경우 리턴 -1
// 큐는 배열로 표현되었고 원소가 배열 앞에 있을수록
// 먼저 집어넣은 원소

// 샌드박스
// 일단 queue를 가지고 놀기 위해서 저 배열을 큐로
// 바꿔줘야하지 않을까싶고
// 문제를 잘 읽어보면 일단 이 큐에 합친 값을 꺼내고
// 그거를 반으로 나눠서 그게 타겟값이라고 생각하면 될것
// 같음
// 그리고 dfs를 돌리기엔 수가 길어질수있음
// 근데 필요한 작업의 최소 횟수이니깐 bfs인가?? 생각
// 근데 큐길이가 300,000이라 저울재기 방식을 추천함
// 그리고 합 계산중 오버플로우가 발생할수있으니 long 타입 사용

import java.util.LinkedList;
import java.util.Queue;

class MakeEqualQueue {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int n : queue1) {
            que1.offer(n);
            sum1 += n;
        }
        for (int n : queue2) {
            que2.offer(n);
            sum2 += n;
        }

        while (true)
        {
            if (answer > queue1.length * 4) {
                return -1;
            }
            if(sum1 > sum2)
            {
                int temp = que1.poll();
                sum1 -= temp;
                que2.offer(temp);
                sum2 += temp;
                answer++;
            } else if (sum2 > sum1) {
                int temp = que2.poll();
                sum2 -= temp;
                que1.offer(temp);
                sum1 += temp;
                answer++;
            }
            else{
                return answer;
            }
        }
    }
}
