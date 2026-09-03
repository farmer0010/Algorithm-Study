package Day139;

// 다리를 지나는 트럭

// 트럭 여러대가 일차선 다리를 정해진 순으로 건너려고함
// 모든 트럭이 다리를 건너려면 최소 몇초 걸리는지 찾아야함

// 다리에는 최대 bridge_length 만큼 올라갈수있고 다리는 weight 이하까지의 무게를
// 견딜 수있음

// 샌드박스
// 경과 시간을 보면 어떨 떄는 1~2초, 6~7초 이렇게 표기되는게 있는데
// ㄴ 지금 보니 다리를 건너는 트럭에 대기 트럭이 합류하는게 못한다면 1초가 더 추가되서 1이
// 늘어나고 그리고 다리를 지난 트럭이 추가되면서 1이 늘어남 그래서 1~2 이런식으로 표기됨
// 이게 일반애들과 다른 차이가 뭔지 파악해보는게 중요할듯
// 일단 큐를 활용해서 왔다갔다 하되 다음 얘를 큐에 더한 애가 무게를 넘기면 또 그게 안되니깐
// 그거에 맞게 로직을 짜야해볼듯함

import java.util.*;

class TruckBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total_weight = 0;
        int nextIdx = 0;

        // 다리를 지난 트럭, 다리를 건너는 트럭
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }

        while(total_weight > 0 || nextIdx < truck_weights.length){
            int m_w = q.poll();
            total_weight -= m_w;

            if(nextIdx < truck_weights.length && total_weight + truck_weights[nextIdx] <= weight){
                q.offer(truck_weights[nextIdx]);
                total_weight += truck_weights[nextIdx];
                nextIdx++;
            }
            else{
                q.offer(0);
            }
            answer++;
        }

        return answer;
    }
}
