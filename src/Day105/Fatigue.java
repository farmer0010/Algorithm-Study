package Day105;

// 피로도

// 게임에는 피로도 시스템이 있고 일정 피로도를 사용해서
// 던전을 탐험 할 수 있고 각 던전마다 탐험을 시작하기 위해
// 필요한 최소 피로도와, 던전 탐험을 마쳤을 때 소모되는 소모 피로도
// 가 있음
// 최소 필요 피로도는 해당 던전을 탐험하기 위해 가지고 있어야하는
// 최소한의 피로도를 나타내며, 소모 피로도는 던전을 탐험한 후
// 소모되는 피로도를 나타냄

// 하루에 한번씩 탐험 할수 있는 던전이 여러개 있고 한 유저가
// 오늘 이 던전들을 최대한 많이 탐험하려고 함
// 현재 유저의 피로도 k와 각 던전별 최소 필요 피로도, 소모 피로도가
// 담긴 2차원 배열 dungeons가 매개변수로 주어질 때 최대 던전수를
// 리턴하도록 하시오

// 샌드박스
// 1. 던전의 개수가 8개 밖에 되지않기 떄문에 dfs로 모든 경우의
// 수를 찾아 최대 갯수를 뽑아내야함
// 2. dfs의 핵심은 종료 조건인데 피로도가 소모되서
// 던전을 다 못돌수도 있으니 피로도가 0이 되면 그게 종료조건이겠지??
// 3. 종료 이후 각 경우의 수를 저장해서 Math.max()를 통해서 최대값을 뽑아
// 내면 되지않을까라고 생각함

class Fatigue {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k,0,dungeons,visited);
        return answer;
    }

    private void dfs(int k, int count, int[][] dungeons, boolean[] visited) {
        answer = Math.max(answer, count);

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count+1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}