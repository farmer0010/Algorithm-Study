package Day9;

class Fatigue {
    int maxCount = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return maxCount;
    }

    private void dfs(int k, int[][] dungeons, int count) {
        // 1. 현재까지 돈 횟수랑 최대 회수 비교해서 갱신
        maxCount = Math.max(maxCount, count);
        // 2. 모든 던전을 둘러보면 갈수 있는 곳 가기
        for (int i = 0; i< dungeons.length; i++) {
            // A 조건: 아직 안간 곳이고 (visited[i] = false)
            // B 조건: 피로도가 충분하다면 (k >= 최소 필요도)
            if(!visited[i] && k>=dungeons[i][0])
            {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }

            }
        }
    }
