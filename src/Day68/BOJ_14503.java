package Day68;

// 로봇 청소기

// 로봇 청소기와 방의 상태가 주어졌을 때 청소하는 영역을 갯수 구하기
// 로봇 청소기가 있는 방은 N * M 크기의 직사각형
// 각각 1*1 크기의 정사각형 칸으로 나누어져있음

// 청소기가 바라보는 방향은 동, 서, 남, 북중의 하나
// 방의 각 좌표는 (r,c)
// 가장 북쪽칸의 서쪽 좌표는 0,0
// 가장 남쪽줄의 가장 동쪽 칸의 좌표는 (N-1, M-1)
// 즉 좌표 r,c는 북쪽에서 r+1, 서쪽에서 c+1 칸을 가리킴

// 작동원리
// 1. 현재칸이 아직 청소되지않은 경우 현재 칸을 청소함
// 2. 현재 칸의 주변 4칸중 청소되지않은 빈칸이 없는 경우
//  1. 바라보는 방향을 유치한채로 한칸 후질 할수있다면 한칸 후진하고 1번으로 돌아감
//  2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
// 3. 현재 칸의 주변 4칸중 청소되지않은 빈칸이 있는 경우,
//  1. 반시계 방향으로 90도 회전한다
//  2. 바라보는 방향을 기준으로 앞쪽칸이 청소되지않는 경우 한칸 전진한다
//  3. 1번으로 돌아간다

// 입력값 : 첫째줄에 방의 크기 N과 M이 주어짐
// 둘째줄에 처음에 로봇 청소기가 있는 좌표와 바라보는 방향 d가 주어짐
// d가 0인 경우 북쪽, d가 1인 경우 동쪽, 2인경우 남쪽, 3인 경우 서쪽
// 셋째줄 부터 N개 줄에 각 장소의 상태를 나타내는 N * M개의 값이 한줄에
// M개씩 입력됨
// 상태값이 0인 경우는 청소되지않은 빈칸, 1인 경우는 벽이 있는 경우

// 왼쪽과 후진을 어떻게 표현할지 고민
// 후진은 방향은 바뀌면 안되고
// 왼쪽 표현이 빡세노 dir = (dir+3) % 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int map[][];
    static int N;
    static int M;
    static int r;
    static int c;
    static int dir;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        // 맵그리기 까지 성공
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean_robot(r,c,dir);
    }

    private static void clean_robot(int r, int c, int d) {
        int curx = r;
        int cury = c;
        int dir = d;
        int count = 0;

        while(true)
        {
            if(map[curx][cury] == 0)
            {
                map[curx][cury] = 2;
                count++;
            }
            boolean isMove = false;
            for(int i = 0;i<4;i++)
            {
                dir = (dir+3) % 4;
                int nx = curx + dx[dir];
                int ny = cury + dy[dir];

                if(nx >=0 && nx < N && ny >=0 && ny < M && map[nx][ny] == 0)
                {
                    curx = nx;
                    cury = ny;
                    isMove = true;
                    break;
                }
            }
            if(!isMove){
                int backx = curx - dx[dir];
                int backy = cury - dy[dir];

                if(backx >= 0 && backx < N && backy >= 0 && backy < M && map[backx][backy] == 1)
                    break;
                else
                {
                    curx = backx;
                    cury = backy;
                }
            }
        }
        System.out.println(count);
    }
}
