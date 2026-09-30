package Day149;

// 피로도 시스템이 있으며, 일정 피로도를 사용해서 던전을 탐험 할 수있음

// 각 던전마다 탐험을 시작하기 위해 필요한 최소 필요 피로도와, 마쳤을떄 소모되는 소모 피로도가 있음
// 이 게임에는 하루에 한번씩 탐험 할 수있는 던전이 여러개 있고
// 한 유저가 오늘 이 던전들을 최대한 많이 탐험 하려고함

// 유저의 현재 피로도 k, 던전 피로도는 dungeons에 있음

class FatigueDungeon {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {

        boolean check[] = new boolean[dungeons.length];

        dfs(k, 0, dungeons, check);

        return answer;
    }

    public void dfs(int k, int count, int[][] dungeons, boolean check[]){

        for(int i = 0; i < dungeons.length; i++){
            answer = Math.max(answer, count);

            if(!check[i] && dungeons[i][0] <= k){
                check[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons, check);
                check[i] = false;
            }
        }
    }
}
