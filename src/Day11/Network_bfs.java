package Day11;

import java.util.LinkedList;
import java.util.Queue;

class Network_bfs {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, computers, visited);
            }
        }
        return answer;
    }

    private void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for(int next = 0; next < computers.length; next++) {
                if(computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }


    }
}
