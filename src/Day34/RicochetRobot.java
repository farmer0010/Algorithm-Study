package Day34;

// 실수한점 : 슬라이딩으로 미끄러지는 점을 갱신하는점이 한번 있어야했는데
// 그냥 점 하나하나씩 이동하면 체크로직을 짬..
// 그리고 먼저 범위를 체크하고 보드의 이동의 안정을 생각하지않아서 인덱스가 터짐

import java.util.LinkedList;
import java.util.Queue;

class RicochetRobot {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<int []> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R')
                {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int []cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(board[x].charAt(y) == 'G')
                return count;
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                while (true)
                {
                    int rx = nx + dx[i];
                    int ry = ny + dy[i];
                    if(rx < 0 || ry < 0 || rx >= n || ry >= m || board[rx].charAt(ry) == 'D')
                    {
                        break;
                    }
                    nx = rx;
                    ny = ry;
                }
                if(!visited[nx][ny])
                {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1;
    }
}
