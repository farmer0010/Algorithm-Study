package Day23;

import java.util.Arrays;
import java.util.PriorityQueue;

class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0; // 현재 시각
        int idx = 0; // jobs 배열에서 몇번쨰 작업까지 했는지
        int count = 0; // 처리 완료한 개수
        // 1. 요청 시간 기준으로 오름차순 정렬
        Arrays.sort(jobs,(o1, o2) -> o1[0] - o2[0]);
        // 2. 우선 순위 큐(소요시간이 짧은데로 정렬)
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while(count<jobs.length){
            // 현재시각 이전에 요청된 모든 작업을 큐에 넣기
            // 조건 idx가 배열 범위 내이고, jobs[idx] 요청시간이 time보다 작거나 같으면
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx++;
            }
            // 큐에서 작업 꺼내서 처리하기
            if (!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                count++;
            }
            else
                time = jobs[idx][0];
        }
        return answer / jobs.length;
    }
}
