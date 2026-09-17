package Day145;

// 각 칸마다 색이 칠해진 2차원 격자 보드판이 있음
// 그중 한 칸을 골랐을 때 위, 아래, 왼쪽, 오른쪽 칸중 같은 색깔로 칠해진 칸의 개수를 구하려고함

// 보드는 각 칸에 칠해진 색깔 이름이 담긴 이차원 문자열 리스트 board와 고른 칸의 위치를 나타내는 두 정수
// h, w가 주어질때 board[h][w]가 주어질때 이웃한 칸들중 같은 색으로 칠해져있는 칸의 개수를 리턴

class AdjacentSameColor {
    int dh[] = {0,1,-1,0};
    int dw[] = {1,0,0,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];

        for(int i = 0; i < 4; i++){
            int next_h = h + dh[i];
            int next_w = w + dw[i];

            if(next_h >= 0 && next_h < board.length && next_w >= 0 && next_w < board.length){
                if(board[h][w].equals(board[next_h][next_w]))
                    answer++;
            }
        }

        return answer;
    }
}
