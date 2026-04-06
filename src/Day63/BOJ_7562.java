package Day63;

// 나이트의 이동

// 체스판 위에 한 나이트가 있음
// 나이트가 이동하려는 칸이 주어지고
// 나이트는 여기에서 몇번 움직이면 이 칸으로 이동 할 수있을까?

// 입력 첫째 줄에는 테스트 케이스 갯수
// 첫째 줄에는 체스판 한변의 길이 I가 주어짐 (4 ~ 300)
// 체스판의 각 칸의 두수의 쌍으로 나타낼수 있음
// 둘째줄 : 나이트가 현재 있는 칸
// 셋째줄 : 나이트가 이동해야하는 칸

// 리턴값: 각 테스트 케이스 마다 나이트가 최소 몇번 이동할수 있는지?
// 최소값 출력해야하니깐 bfs 하지만 dx, dy의 어디로 이동할지 경로를 잡아주는게
// 포인트일듯

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static int dx[] = {-2,-1,1,2,2,1,-1,-2};
    static int dy[] = {1,2,2,1,-1,-2,-2,-1};
    static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            map = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            bfs_knight(start_x,start_y,end_x,end_y);
        }
    }

    private static void bfs_knight(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX,startY});
        map[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            if (curX == endX && curY == endY) {
                System.out.println(map[curX][curY] -1);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX <= map.length -1  && nextY <= map[0].length -1 && map[nextX][nextY] == 0) {
                    map[nextX][nextY] = map[curX][curY] + 1;
                    queue.add(new int[] {nextX,nextY});
                }
            }
        }
    }
}
