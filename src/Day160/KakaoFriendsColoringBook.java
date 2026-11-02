package Day160;

// 카카오 프렌즈 컬러링 북

// 이 문제는 상하좌우로 연결된 공간의 영역의 수로 정의
// 그림에 몇개의 영역이 있는지와 가장 큰 영역의 넓이를 계산해야됨
// bfs를 통해서 영역의 개수와, 거기에서 가장 큰 영역의 넓이 또한 계산해야함
// 0이 아니면서 같은 숫자로 연결되어야함을 인지

import java.util.*;

class KakaoFriendsColoringBook {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] isVisit;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        isVisit = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int k = 0; k < n; k++){
                if(!isVisit[i][k] && picture[i][k] != 0){
                    int count = bfs(i, k, picture);
                    maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private int bfs(int x, int y, int[][] picture){
        Queue<int []> q = new LinkedList<>();

        int cnt = 1;

        q.offer(new int[]{x, y});
        isVisit[x][y] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();

            int startX = cur[0];
            int startY = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = startX + dx[i];
                int ny = startY + dy[i];

                if(nx >= 0 && nx < picture.length && ny >= 0 && ny < picture[0].length){
                    if(!isVisit[nx][ny] && picture[startX][startY] == picture[nx][ny]){
                        q.offer(new int[]{nx, ny});
                        isVisit[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
