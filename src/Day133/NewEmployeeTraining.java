package Day133;

// 신입 사원 교육

// 신입 사원중 2명을 선발하고 선발된 2명이 같이 공부를 시킴
// 모든 신입 사원의 능력치는 정수로 표현되고 2명의 신입 사원이 같이 공부하면
// 서로의 능력을 흡수해서 두 신입 사원의 능력치는 공부전 두 사람의 능력치의 합이 됨

// 선발된 2인의 교육이 끝나면 다시 2인을 선발하여 교육을 진행할 수 있고
// 이떄 선발된 사원이 재선발 될수도 있다

// 신입 사원들의 능력치를 나타내는 정수 배열 ability와
// 민수가 교육을 진행해야하는 횟수 정수 number이 주어졌을 때
// 모든 사원의 능력치의 합을 구하시오

// 샌드박스 :
// 그리디를 통한 우선 순위 큐를 쓰면 될 것같은데
// 두개를 꺼내고 값을 합친 다음에 다시 큐에 넣어야함

import java.util.*;

class NewEmployeeTraining {
    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < ability.length; i++){
            pq.offer(ability[i]);
        }

        while(number > 0){
            int first = pq.poll();
            int second = pq.poll();

            int total = first + second;
            pq.offer(total);
            pq.offer(total);

            number--;
        }

        while(!pq.isEmpty()){
            answer += pq.poll();
        }

        return answer;
    }
}
