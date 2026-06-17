package Day97;

// 네트워크

// 네트워크란 컴퓨터 상호간에 정보를 교환할 수 있도록
// 연결된 형태를 의미한다
// 예를 들어 컴퓨터 a와 컴퓨터 b가 직접적으로 연결되어있고
// 컴퓨터 b와 c가 직접적으로 연결되어있을 때
// 컴퓨터 a와 c도 연결되어있다
// 따라서 컴퓨터 a와, b와 c는 같은 네트워크 상에 있다고 할수있다.

// 컴퓨터 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가
// 매개변수로 주어질 때 네트워크의 개수를 리턴 하도록 하시오
// 샌드박스 : 어떻게 보면 플루이두 워셜로도 가능한 조건에 있고
// bfs에 일단 훨씬 가깝긴하다
// 일단 이 연결된 지도를 만들어주는게 중요함

import java.util.LinkedList;
import java.util.Queue;

class NetWork {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs_netWork(i, n, computers);
                count++;
            }
        }

        return count;
    }

    private void bfs_netWork(int start, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i < n; i++){
                if(cur != i && computers[cur][i] == 1 && !visited[i])
                {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }


}