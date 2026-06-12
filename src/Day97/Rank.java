package Day97;

// 순위
// n명의 권투선수가 권투대회에 참여했고
// 1번부터 n번까지 번호가 부여됨
// 권투 경기는 1:1 방식으로 진행
// a선수가 b선수보다 실력이 좋다면 a선수는 b선수를 항상이김
// 심판은 주어진 결과를 가지고 순위를 매기려함
// 하지만 몇명 경기 결과를 분실하여 정확한 순위를 매길수 없음
// 선수의 수 n과 경기 결과를 담은 result 배열을 가지고
// 정확하게 순위를 매길수 있는 선수의 수를 리턴해야함
// [A,B]같은 경우엔 A선수가 승자임
// 샌드 박스
// 힌트를 보지않고 생각한다면 예를 들어 1명이 이긴 사람의 수의 배열과
// 진사람의 배열을 저장할 수있는 자료구조를 만들어서 생각해야하나??
// 뭔가 예측 할수 있게하는 뭔가가 필요할 것같은데 그게 애매하네

// 나를 제외한 모든 선수 (n-1)과 승패관계가 확실하게 정리되어있는가를
// 확인해야함

// 플로이드 워셜임을 알아챌수있는 힌트
// 정점의 개수가 1~200정도로 터무니 없이 작을 떄
// 모든 정점끼리의 관계를 조사해야할 때
// 삼단 논법 추론이 필요할떄

class Rank {
    public int solution(int n, int[][] results) {
        boolean[][] record = new boolean[n+1][n+1];

        for (int[] res : results) {
            int win = res[0];
            int lose = res[1];
            record[win][lose] = true;
        }

        for(int k = 1 ; k <= n; k++){
            for(int i = 1 ; i <= n; i++){
                for(int j = 1 ; j <= n; j++){
                    if(record[i][k] && record[k][j]){
                        record[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n; i++){
            int count = 0;
            for(int j = 1 ; j <= n; j++){
                if(record[i][j] || record[j][i]){
                    count++;
                }
            }
            if(count == n-1)
                answer++;
        }
        return answer;
    }
}
