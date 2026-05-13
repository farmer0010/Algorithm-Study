package Day86;

// 숫자 변환하기

// 사용할수 있는 연산
// x + n
// x * 2
// x * 3
// 자연수 x,y,n 매개변수로 주어 질때 x를 y로 변환하기 위한
// 필요 최소 연산횟수를 리턴하고 이 떄 x를 y로 만들수 없다면
// 리턴 -1

// bfs나 dp 둘 중 하나로 생각해야한다 감은 오는데
// dp로는 안풀어본지 오래돼서 기억이 잘 안나네

import java.util.LinkedList;
import java.util.Queue;

class NumberConversion {
    public int solution(int x, int y, int n) {
        int answer = bfs_num(x, y, n);
        if (x == y)
            return 0;
        return answer;
    }

    private int bfs_num(int start, int target, int n) {
        Queue<int []> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000001];

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int cur_num = cur[0];
            int cur_cnt = cur[1];

            int[] next = {cur_num + n, cur_num * 2, cur_num * 3};
            for (int num : next) {
                if (num == target)
                    return cur_cnt + 1;
                if (num < target  && !visited[num]) {
                    visited[num] = true;
                    queue.offer(new int[]{num, cur_cnt + 1});
                }
            }
        }

        return -1;
    }


}