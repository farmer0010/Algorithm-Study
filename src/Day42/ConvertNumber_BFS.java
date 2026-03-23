package Day42;

// 숫자 변환하기
// x를 y로 변환하려고 함
// 사용할 수 있는 연산 3가지
// 1, x+n 을 더하는 방식
// 2. x * 2를 곱하는 방식
// 3. x * 3을 곱하는 방식
// 리턴값: x를 y로 변환시키기 위해 필요한 최소 연산 횟수
// x를 y로 변환할 수 없다면 -1 리턴

import java.util.LinkedList;
import java.util.Queue;

class ConvertNumber_BFS {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[1000001];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x,0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0]; // 지금 현재 수
            int steps = cur[1]; // 연산횟수

            if(num == y){
                return steps;
            }
            int[] nextNum = {num+n , num*2, num*3};
            for (int next : nextNum) {
                if(next <= y && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next,steps+1});
                }
            }
        }
        return -1;
    }
}
