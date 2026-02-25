package Day42;

// 무인도 여행
// 지도 : 바다와 무인도 정보 표기
// 1x1 크기의 사각형들로 직사각형 격자형태
// 격자의 각칸에는 1~9(무인도)나 x(바다)가 표시됨
// 상 하 좌 우 로 연결되는 땅들은 하나의 무인도
// 상 하 좌 우로 연결되는 칸에 적힌 숫자는
// 식량을 나타내는데 모두 합한 값은 최대 며칠동안
// 머무를 수 있는지를 나타탬
// 리턴값: 머무를수 있는 모든 날의 값
// 만약 머무를 없다면 리턴값 -1

// 샌드박스
// bfs면 준비물이 뭘까? 일단 방문 체크용 필요하고
// 큐 필요하지?
// 이중 for문을 사용하여 지도 끝까지 흝어보는데
// 현재칸이 바다도 아니고 방문하지않은 곳이라면?
// 이라는 조건을 만족하면 탐색 시작하게 if문
// 나는 bfs로는 푸는데 상화좌우 탐색을 어떻게 시킬지
// 고민이 필요하다 일단 느낌상
// dx[] = {-1,1,0,0}
// dy[] = {0,0,1,-1} -> 이런식으로 이동할 그거를 만들어두면 좋지않을까라는
// 생각정도듬

import java.util.*;

class UninhabitedIsland {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    boolean[][] visited;
    public int[] solution(String[] maps) {
        List<Integer> Islands = new ArrayList<>();
        int rows = maps.length;
        int cols = maps[0].length();
        // 방문 기록장 준비 완료
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    int total = bfs(i,j,maps,rows,cols);
                    Islands.add(total);
                }
            }
        }
        if(Islands.isEmpty()){
            return new int[]{-1};
        }
        Collections.sort(Islands);
        return Islands.stream().mapToInt(i -> i).toArray();
    }

    private int bfs(int startX, int startY, String[] maps, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int sum = maps[startX].charAt(startY) - '0';
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++)
            {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < rows && ny < cols)
                {
                    if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        sum += maps[nx].charAt(ny) - '0';
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return sum;
    }
}
