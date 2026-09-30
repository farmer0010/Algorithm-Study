package Day149;

// 네트워크

// 컴퓨터 a와 컴퓨터 b가 직접적으로 연결되어있고
// 컴퓨터와 b와 컴퓨터 c가 연결되어있다면
// 컴퓨터 a와 c는 간접적으로 연결되어 같은 네트워크 상에 볼수있다

// 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 배열 computers
// 네트워크 개수를 리턴

class Network {
    int answer = 0;
    boolean visited[];
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int cur, int[][] computers){
        visited[cur] = true;

        for(int next = 0; next < computers.length; next++){
            if(!visited[next] && computers[cur][next] == 1){
                dfs(next, computers);
            }
        }
    }
}