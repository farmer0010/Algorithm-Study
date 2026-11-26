package Day173;

// 각 던전 마다 최소 필요 피로도와, 소모 피로도가 존재
// 최소 필요 피로도: 던전을 탐험하기 위해 가지고 있어야하는 최소한의 피로도
// 소모 피로도 던전을 탐험 한후 소모되는 피로도

// 유저가 탐험할 수 있는 최대 던전의 수를 리턴

// 상황에 맞게 피로도가 처리되서 정렬로는 그 이점을 받을 수 없음
// 던전의 길이가 최대 8이면 재귀를 통해 각 경우의 수를 만들어
// 거기에서 제일 높은 치를 뽑아내는게 나아보임

class Fatigue {
    int max = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        visit = new boolean[dungeons.length];

        dfs(k, 0, dungeons);
        answer = max;

        return answer;
    }

    public void dfs(int k, int count, int[][] dungeons){

        max = Math.max(max, count);

        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && k >= dungeons[i][0]){
                visit[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons);
                visit[i] = false;
            }
        }
    }
}
