package Day124;

// 파고되지않는 건물

// N * M 크기의 행렬 모양 게임 맵이 있음
// 이 맵에는 내구도를 가진 건물이 각 칸마다 하나씩 있고
// 건물은 적의 공격을 받으면 내구도가 감소하고 내구도가 0이하가 되면 파괴된다.
// 반대로 아군은 회복 스킬을 사용하여 건물들의 내구도를 높이려고 한다
// 건물은 파괴되어도 회복 스킬을 통해 회복이 가능함 (내구도가 0이하가 된 이미 파괴된 건물도
// 공격을 받으면 계속해서 내구도가 내려감)

// 스킬의 각행은 [type(1일 경우 공격, 2일 경우 아군 회복), r1, c1, r2, c2, degree] r은 행 c는 열

// 샌드박스
// 내가 생각하기는 구현 문제에 가까운데
// 저 본판 보드를 그대로 계속 쓰는 것보다 똑같은 복제 모드를 하나 만들어주는게 좋을 것같음
// 내구도 깎고 체크 하는 작업을 안전하게 하기 위해서??

// 처음에 반복문으로 구현했지만 정확성 테스트는 통과하지만 효율성 테스트에서 박살남

// 공부점 : 차분 배열 활용
// 각 사각형의 꼭지점과, + , - 플래그를 이요하여 누적합을 이용한다
// 범위 1 ~ r1까지 채워야할 때 하나하나 돌리지않고 깔끔하게 채울수있다. 끝나는 지점까지 영향을 줘야되니깐 1칸을 더 먹어줘야함
// 누적합은 항상 왼쪽의 값이 필요하기떄문에 1부터 필요함

class DestroyedBuildings {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        long[][] diff = new long[n+1][m+1];

        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1] , c1 = s[2], r2 = s[3], c2=s[4];
            int degree = s[5];
            long val = type == 1 ? -degree : degree;
            diff[r1][c1] += val;
            diff[r1][c2+1] -= val;
            diff[r2 +1][c1] -= val;
            diff[r2+1][c2+1] += val;
        }

        // 1차: 가로방향 누적합
        for(int i = 0; i <= n; i++){
            for(int j = 1; j <= m; j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        // 2차: 세로 방향 누적합
        for(int j = 0; j <= m; j++){
            for(int i = 1; i <= n ; i++){
                diff[i][j] += diff[i-1][j];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] + diff[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}
