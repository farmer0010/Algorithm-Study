package Day90;

// 네트워크란 컴퓨터 상호간에 정보를 교환할 수 있도록 연결된 형태를 의미함
// 예를 들어 컴퓨터 a,b과 직접적으로 연결되어있고, 컴퓨터 b,c가 직접적으로
// 연결되어 있으면 컴퓨터 a,c도 간접적으로 연결되어있다고 볼수있음
// 컴퓨터 개수 n과 연결에 대한 정보를 담은 2차원 배열 computers
// 가 매개변수로 주어질 떄 네트워크의 개수를 리턴

// 일단 bfs로 영역의 개수를 세는 문제같은데
// 시작점을 어떻게 잡아주는지도 문제이긴함

import java.util.LinkedList;
import java.util.Queue;

class Network {
    static boolean[] isVisited;
    public int solution(int n, int[][] computers) {
        isVisited = new boolean[n + 1];
        int answer = 0;

        for(int i=0; i < n; i++){
            if(!isVisited[i]){
                bfs_net(i, computers);
                answer++;
            }
        }
        return answer;
    }

    private void bfs_net(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for (int end=0; end < computers.length; end++){
                if(computers[cur][end] == 1 && !isVisited[end]){
                    isVisited[end] = true;
                    q.offer(end);
                }
            }
        }
    }
}
