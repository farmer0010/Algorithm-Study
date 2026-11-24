package Day171;

class Network {
    boolean[] isVisit;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        isVisit = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!isVisit[i]){
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int cur, int[][] computers){
        for(int i = 0; i < computers.length; i++){
            if(!isVisit[i] && computers[cur][i] == 1){
                isVisit[i] = true;
                dfs(i, computers);
            }
        }
    }
}
