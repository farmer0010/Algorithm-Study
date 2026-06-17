package Day100;

// 부대 복귀

// 각 부대원이 여러지역에 뿔뿔이 흩어져 임무를 수행중임
// 지도에서 부대가 위치한 지역을 포함한 각 지역은
// 유일한 번호로 구별되며, 두 지역 간의 길을 통과하는데
// 걸리는 시간은 모두 1로 동일, bfs 쓰면 되겠네
// 임무를 수행한 각 부대원은 지도 정보를 이용하여 최단 시간
// 내에 부대로 복귀하고자함, 다만 적군의 방해로 인해 임무
// 시간떄와 다르게 되돌아오는게 불가능한 부대원도 있음

// 부대가 위치한 지역을 포함한 지역의 수 n
// 두 지역을 왕복할 수있는 길의 정보를 담은 지역의 개수
// 두 지역을 왕복할 수있는 길을 담은 road
// 각 부대원이 위치한 정수 배열 source
// 복귀해야되는 지역 dest
// 복귀할 수있는 최단 시간을 담은 배열을 리턴해야함
// 복귀가 불가능한 경우엔 최단시간 -1을 리턴

// 일단 클래스를 하나 만들어줄듯
// start, end로
// 그러고 해시맵을 통해 인테저와 노드를 저장하는 맵구조 하나 만들어주고
// 방문 여부를 체크 해둬야되니깐 노드 자체에 플래그를 의미하는게
// 하나 추가적으로 있지않아야되나? 싶음
// -> 나는 여러경로를 체크하려고했는데 이 구조를 사용하게 되면
// 굉장히 까다로워지기 떄문에 인접리스트 배열을 활용해보자
// 그리고 맵을 하나 만들어주고 roads를 통해 그 부분의 값을 1로
// 바꿔준 다음에 이동 시키면 될듯한디
// 내 생각은 부대원들 위치마다 bfs를 돌릴려고했지만 그렇기에
// 크기가 너무 커져서 목적지에서 시작해서 부대원들로 가는걸
// 기록하는거임

// 인접행렬 배열은 배열의 쉽게 생각하면 각 도시마다 이동할 수있는
// 이웃도시만 적어둔 도시별 연락처
// 제일 헷갈렸던 부분 map 2차원 배열로 기록해주는게 낫지않을까?
// 생각했지만 인접리스트 배열의 경우엔, 이제 확실히 크기가 크게
// 주어지는 경우 그리고 이웃도시랑 연결 정보 관리가 필요할떄?
// 필요하다

// 역발상이 필요할떄 다 : 1구조일떄 (출발지는 하나인데 목적지는 여러개)
// 출발지의 수가 터무니 없이 많을 떄
// 길이 양방향 일떄

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TroopReturn {
    ArrayList<Integer >[] ans;
    int dist[];
    static final int INF = 1_00_000_000;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //1. 일단 연결 정보를 가지고 맵을 만들어주자
        ans = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = new ArrayList<>();
        }

        dist = new int[n+1];
        Arrays.fill(dist, INF);

        for( int i = 0; i < roads.length; i++ ) {
            int start = roads[i][0];
            int end = roads[i][1];

            ans[start].add(end);
            ans[end].add(start);
        }

        bfs_dest(destination);
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            int personLoc =  sources[i];
            if(dist[personLoc] == INF){
                answer[i] = -1;
            }
            else{
                answer[i] = dist[personLoc];
            }
        }

        return answer;
    }

    private void bfs_dest(int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        dist[destination] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : ans[cur]){
                if(dist[next] ==  INF){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
