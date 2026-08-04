package Day124;

// 두 큐 합 같게 만들기

// 길이가 같은 두개의 큐가 주어짐

// 하나의 큐를 골라 원소를 추출하고 추출된 원소를
// 다른 큐에 집어넣는 작업을 통해 각 큐의 원소의 합이 같도록 하려고한다.
// 이떄 필요한 작업의 최소 회수를 구하려고하고 (한번의 pop과 한번은 insert를 합친게 1번의 작업을 의미함)

// 예를 들어 큐1과 큐2의 합을 합친값이 30이면 각 큐의 값을 15로 만들어줘야함

// 샌드박스
// 1. 일단 두개의 큐를 만들어주고 그 큐에 저 숫자 배열을 먼저 집어넣어준다
// 2. 그리고 종료되는 조건은 큐1과 큐2의 합이 같아질 떄 그러면 일단 두개의 합친값을 구해주고
// 그걸 반으로 나눠줘야하겠지?

import java.util.*;

class TwoQueueSum {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        int length = queue1.length * 2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += (long)queue1[i];
            sum2 += (long)queue2[i];
        }

        long avg = (sum1 + sum2) / 2l;

        while(length > 0){

            if(sum1 == avg || sum2 == avg){
                break;
            }

            if(length == 1){
                return -1;
            }

            if(sum1 < avg){
                int n = q2.poll();
                q1.offer(n);
                sum1 += n;
                sum2 -= n;
                answer++;
                length--;
            }
            else if(sum2 < avg){
                int n = q1.poll();
                q2.offer(n);
                sum2 += n;
                sum1 -= n;
                answer++;
                length--;
            }
        }

        return answer;
    }
}
