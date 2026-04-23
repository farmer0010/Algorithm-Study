package Day76;

// 자물쇠와 열쇠

// 튜브가 보물과 유적이 있는 비밀의 문을 발견함
// 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨있음
// 문앞에 열쇠와 자물쇠를 푸는 방법이 적혀있음

// 잠겨있는 자물쇠는 격자 한칸의 크기가 1*1인 n*n 크기의 정사각형 격자
// 형태이며, 특이한 모양의 열쇠는 m*n크기인 정사각 격자형태로 되어있음

// 자물쇠에는 홈이 파져있고 열쇠 또한 홈과 돌기부분이 있음
// 열쇠는 회전과 이동이 가능하며 열쇠 돌기 부분을
// 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조임

// 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를
// 여는데 영향을 주지않으며 자물쇠 영역 내부에서는 열쇠의 돌기
// 부분과 홈부분이 정확히 일치해야 열림
// 자물쇠의 홈을 채워 비어있는 곳이 없어야 자물쇠를 열수있음

// 열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이
// 매개변수로 주어질 때 열쇠로 자물쇠를 열수있으면 true, 없으면 false

class Solution_60059 {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        // 여유공간을 만들어둠
        int[][] newlock = new int[n*3][n*3];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                newlock[i+n][j+n] = lock[i][j];
            }

        for(int r=0; r < 4; r++){
            key = rotate(key);
            for(int x = 0; x < n * 2; x++){
                for(int y = 0; y < n * 2; y++){

                    for(int i = 0; i < m; i++){
                        for(int j = 0; j < m; j++){
                            newlock[x+i][y+j] += key[i][j];
                        }
                    }
                    if(check(newlock, n) == true){
                        return true;
                    }
                    for(int i = 0; i < m; i++){
                        for(int j = 0; j < m; j++){
                            newlock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int[][] newlock, int n) {
        for(int i = n; i < n*2; i++){
            for(int j = n; j < n*2; j++){
                if(newlock[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    private int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] rotatedkey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedkey[j][m-1-i] = key[i][j];
            }
        }
        return rotatedkey;
    }
}
