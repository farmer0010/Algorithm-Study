package Day149;

// 프렌즈 4블록

// 같은 모양의 카카오 프렌즈 블록이 2 * 2 형태로 4개가 붙어있을 경우 사라지면서
// 점수를 얻는 게임

// 샌드박스
// 1. 연결되있는게 있기 떄문에 한번에 지워야하니 일단 연결된 부분을 1로 마킹
// 2. 그리고 블록이 지워진 부분은 내려줘야 하기떄문에 오히려 역순으로 재표기가 필요하지않을까라는 생각이 듬
// 3. 1이라는 마킹이 사라져 0이라는게 사라지면 종료

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
            int count  = 0;
            int i_board[][] = new int[m][n];

            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(n_board[i][j] == n_board[i-1][j-1] && n_board[i][j] == n_board[i-1][j] && n_board[i][j] == n_board[i][j-1] && n_board[i][j] != '0'){
                        i_board[i][j] = 1;
                        i_board[i-1][j] = 1;
                        i_board[i][j-1] = 1;
                        i_board[i-1][j-1] = 1;
                    }
                }
            }
            for(int i = 0; i < i_board.length; i++){
                for(int j = 0; j < i_board[0].length; j++){
                    if(i_board[i][j] == 1){
                        count++;
                        n_board[i][j] = '0';
                    }
                }
            }
            for(int j = 0; j < n; j++){
                int pos = m-1;
                for(int i = m-1; i >=0; i--){
                    if(n_board[i][j] != '0'){
                        char block = n_board[i][j];
                        n_board[i][j] = '0';
                        n_board[pos][j] = block;
                        pos--;
                    }
                }
            }


            if(count == 0)
                break;
            else{
                answer+= count;
            }
        }

        return answer;
    }
}
