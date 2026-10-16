package Day154;

// 하드 디스크는 한번에 하나의 작업만 수행
// 우선 순위 디스크 컨트롤러
// 1. 어떤 작업이 들어왔을때 작업의 번호, 요청시각, 소요시간을 저장해두는 대기 큐가 있고
// 처음에 이 큐는 비어있음
// 2. 하드디스크 작업을 하지않고 대기 큐가 비어있지 않다면 가장 우선 순위가 높은 작업을
// 소요시간이 짧은 것 , 작업의 요청 시각이 빠른것, 작업 번호가 작은 것으로 우선순위가 됨
// 3. 하드 디스크가 어떤 작업을 마치는 시점과 다른 작업이 들어오는 시점이 겹친다면
// 하드 디스크가 작업을 마치자마자 우선 순위가 높은 작업을 대기 큐에서 꺼내 그 작업을 시킴

// 작업 요청의 반환 시간의 평균 정수 부분을 리턴

// 샌드박스
// 1. 일단 작업이 짧은 순서대로 정렬
// 2. 이걸 클래스로 만들어서 해결할지 아니면 일단 정렬 시킬지 고민됨

import java.util.Arrays;
import java.util.PriorityQueue;

class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        int index = 0;
        int count = 0;
        int time = 0;

        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= time){
                pq.offer(new int[]{jobs[index][0], jobs[index][1]});
                index++;
            }
            if(!pq.isEmpty()){
                int cur[] = pq.poll();
                time += cur[1];
                answer += time - cur[0];
                count++;
            }
            else{
                time = jobs[index][0];
            }
        }

        return answer / jobs.length;
    }
}
