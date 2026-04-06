package Day63;

// 스타트링크

// 스타트링크는 총 F층으로 이루어진 고층 건물 사무실에 있고
// 스타트링크가 있는 곳의 위치는 G층이다
// 강호가 지금 있는 곳은 S층이고
// 엘리베이터를 타고 G층으로 이동해야함

// 하지만 이 앨리베이터에는 위 아래 버튼 밖에 없음
// U층 버튼을 누르면 u층 만큼 올라가고
// D층 버튼을 누르면 D층 만큼 내려감

// 리턴값: 버튼을 적어도 몇번 눌러야하는지 구하는 프로그램
// 만약에 엘리베이터를 이용해서 G층에 갈 수 없다면
// use the stairs 출력 해야함

// 입력값은 F, S, G, U, D가 주어지고 건물은 1층 부터 시작 끝층은 F층

// 일단 최솟값으로 생각해야하니깐 bfs로 풀어야될거 같긴함

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int[] map;
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[F + 1];

        bfs_link(S);
    }

    private static void bfs_link(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        map[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();
            if(node == G)
            {
                System.out.println(map[node] -1);
                return;
            }
            int[] next = {node+U, node-D};
            for(int i = 0; i < 2; i++)
            {
                int next_node = next[i];
                if(next_node >= 1 && next_node <= F && map[next_node] == 0)
                {
                    map[next_node] = map[node] + 1;
                    q.offer(next_node);
                }
            }
        }
        System.out.println("use the stairs");
    }
}
