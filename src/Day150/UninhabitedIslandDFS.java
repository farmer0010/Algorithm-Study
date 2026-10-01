package Day150;

// 무인도 여행

// 지도에는 바다와 무인도들에 대한 정보가 표시됨
// 지도는 1*1 사각형들로 이루어진 직사각형 격자형태이며
// 격자의 각 칸에는 x 또는 1~9 사이 자연수가 적혀있음
// 이떄 상화 좌우로 연결되는 땅은 하나의 무인도를 이룸
// 이 모든 것을 합한 값이 최대 며칠동안 머물수있는지임

// maps 배열에 각 섬에서 최대 며칠씩 머무를 수있는지
// 배열에 오름 차순으로 담아서 리턴
// 만약 지낼수없다면 -1 리턴

// 샌드박스
// 일단 처음 떠오르는거는 누적해야되니 dp나 dfs인데, 근데 bfs도 포함이 되어야할것같은 느낌
// dfs로 하면 재귀 종료조건을 잡기 어려울것같은데 근데 움직이는 방향마다 그 내부 축적값이 달라서
// 살짝 고민
// 일단 갔던 부분을 다시 가면 안되니 방문 기록표가 필요해보임

import java.util.*;

class UninhabitedIslandDFS {
    boolean visit[][];
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};

    public int[] solution(String[] maps) {
        ArrayList<Integer> lst = new ArrayList<>();

        int m = maps.length;
        int n = maps[0].length();

        visit = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j] && maps[i].charAt(j) != 'X'){
                    lst.add(dfs(i, j, maps));
                }
            }
        }
        if(lst.isEmpty())
            return new int[]{-1};

        Collections.sort(lst);
        int[] answer = new int[lst.size()];

        int index = 0;

        for(int k : lst){
            answer[index++] = k;
        }

        return answer;
    }

    public int dfs(int x, int y, String[] maps){
        int m = maps.length;
        int n = maps[0].length();


        if(x < 0 || x >= m || y < 0 || y >= n || maps[x].charAt(y) == 'X' || visit[x][y]){
            return 0;
        }

        int sum = maps[x].charAt(y) - '0';
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            sum += dfs(x + dx[i], y + dy[i], maps);
        }
        return sum;
    }
}
