package Day138;

// 프렌즈 4블록

// 같은 모양의 블록 2 * 2 형태로 4개가 붙어있을 경우
// 사라지면서 점수를 얻는 게임

// 같은 블록은 여러 2 * 2에 포함 될 수 있으며, 지워지는 조건에 만족하는
// 2*2 모양이 여러개 있다면 한꺼번에 지워진다.
// 블록이 지워진 후에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다

// 만약 빈공간을 채운 후에 다시 2*2 형태로 같은 모양의 블록이 모이면 다시
// 지워지고 떨어지고를 반복한다

// 샌드박스
// 1. 일단 첫번쨰로 2차원 배열 판을 만들어주고 계속 작업판이 변경되니깐
// 그리고 처음에 2 * 2에 처리가 가능한 애들을 표기해야함
// 거기서 체크해야하는 애들 우 , 우하, 하 이렇게 3파트를 확인하면 됨
// 그래야지 한번에 이 여러개 모양애들이 지워짐
// 2. 다음으로 중력을 어떻게 처리할지 생각 해야함
// 기본판에 넣은대로 바로 나와야되기떄문에 큐로 처리해야하지않나?
// 하나의 관이라고 생각하고

import java.util.ArrayDeque;

class Friends4Block {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] n_board = new char[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                n_board[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            boolean[][] mark = new boolean[m][n];
            boolean isNext = false;

            for(int i = 0; i < mark.length -1; i++){
                for(int j = 0; j < mark[0].length -1; j++){
                    if(n_board[i][j] == n_board[i+1][j] && n_board[i][j] == n_board[i][j+1] && n_board[i][j] == n_board[i+1][j+1] && n_board[i][j] != '0'){
                        mark[i][j] = true;
                        mark[i+1][j] = true;
                        mark[i][j+1] = true;
                        mark[i+1][j+1] = true;
                    }
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(mark[i][j] == true)
                    {
                        n_board[i][j] = '0';
                        answer++;
                        isNext = true;
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                ArrayDeque<Character> dq = new ArrayDeque<>();
                for (int i = 0; i < m; i++) {
                    if (n_board[i][j] != '0') {
                        dq.push(n_board[i][j]);
                    }
                }

                for (int i = m - 1; i >= 0; i--) {
                    if (!dq.isEmpty()) {
                        n_board[i][j] = dq.pop();
                    } else {
                        n_board[i][j] = '0';
                    }
                }
            }
            if(!isNext)
                break;

        }
        return answer;
    }
}
