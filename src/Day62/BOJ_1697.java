package Day62;

// 숨바꼭질
// 수빈이와 동생이 숨바 꼭질을 하고
// 범위는 100,000
// 수빈이는 현재 N, 동생은 점 K에 있음
// 수빈이의 위치가 X일 때 때 걷는 다면 1초후에 X-1 또는 X+1로
// 이동하게 되고 순간이동을 하는 경우엔 2*X의 위치로 이동하게 됨

// 리턴 값 수빈이가 동생을 찾는데 걸리는 가장 빠른 시간

// 일단 bfs인데 뭐 순서대로 다 뒤져봐야할듯한데
// 이동 경로는 +1되거나 -1되거나 2*x가지 경우를 생각해야함


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int[] map;
    static int N;
    static int K;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[100001];

        // 어떻게 맵 안에 얘네의 시작점을 잡아줄까?

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        map[N] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur == K) {
                System.out.println(map[cur] - 1);
                return;
            }
            int step[] = {cur-1, cur+1, cur*2};

            for(int i = 0; i < 3; i++) {
                int next_step = step[i];
                if(next_step >= 0 && next_step <= 100000 && map[next_step] == 0) {
                    map[next_step] = map[cur] + 1;
                    q.offer(next_step);
                }
            }
        }
        System.out.println(map[N] - 1);
    }
}
