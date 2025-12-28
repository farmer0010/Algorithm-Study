package Day11;

// bfs는 방문 체크리스트를 만드는게 중요한것 같음

class Network_dfs {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }
        return answer;
    }

    private void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        // 연결된 다른 컴퓨터 찾기
        for(int next = 0; next <computers.length; next++) {
            // 조건 A: 나랑 연결되어있고
            // 조건 B 아직 방문 안했고
            if(computers[current][next] == 1 && !visited[next]) {
                dfs(next, computers, visited);
            }
        }
    }
}
