package Day127;

// 순위

// n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았다
// 권투 경기는 1:1 방식으로 진행이 되고 만약 A선수가 B선수보다 실력이 좋다면
// A 선수는 B 선수를 항상 이김
// 심판의 주어진 경기 결과를 가지고 선수들의 순위를 매기려 함
// 하지만 몇몇 경기 결과를 분실함
// 선수의 수 n, 경기 결과를 담은 배열 results가 매개변수로 주어질 떄
// 정확하게 순위를 매길 수 있는 선수의 수를 리턴

// result의 각행 a,b 는 a선수가 b선수를 이겼다는 의미임

// 샌드박스
// 일단 승패는 boolean을 통해 기록 해둠
// 그리고 어제 사용한 a -> b 이면 b -> c 이러한 추론을 사용해야함
// 그 갯수가 (n-1)개의 도달되면 정확히 순위 매겨진 사람의 갯수가 나옴

class Ranking {
    public int solution(int n, int[][] results) {
        int k = results.length;
        int v = results[0].length;

        boolean[][] battle = new boolean[n+1][n+1];

        for(int i = 0; i < k; i++){
            int win = results[i][0];
            int lose = results[i][1];

            battle[win][lose] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int w = 1; w <= n; w++){
                for(int l = 1; l <= n; l++)
                    if(battle[w][i] && battle[i][l]){
                        battle[w][l] = true;
                    }
            }
        }
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(battle[i][j] == true || battle[j][i] == true)
                    count++;
            }
            if(count == n-1){
                answer++;
            }
        }

        return answer;
    }
}
