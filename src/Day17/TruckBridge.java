package Day17;

import java.util.LinkedList;
import java.util.Queue;

class TruckBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<Integer>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0;
        int trunkIndex = 0; // 대기중인 트럭순서
        while (trunkIndex < truck_weights.length) {
            // 시간 1초 흐름 -> 다리 맨앞이 트럭(또는 0이 빠짐)
            int exitdfTruck = bridge.poll();
            currentWeight -= exitdfTruck;
            time++;
            // 다음 트럭이 올라갈수있는지 확인
            // 가능하면 진짜 트럭을 offer, 무게 추가, 인덱스 ++
            if(currentWeight + truck_weights[trunkIndex] <= weight ) {
                bridge.offer(truck_weights[trunkIndex]);
                currentWeight += truck_weights[trunkIndex];
                trunkIndex++;
            }
            // 불가능 하면 0을 offer(자리만 채우기)
            else {
                bridge.offer(0);
            }
        }
        return time + bridge_length;
    }
}
