package Day78;

// 틱택토

// 3*3 빈칸으로 이루어진 게임판에 선공이 "O", 후공이 "X"
// 가로, 세로, 대각선으로 3개가 같은 표시가 만들어지면
// 같은 표시를 만든 사람이 승리하고 게임이 종료되며
// 9칸이 모두 차서, 더이상 표시할수 없는 경우 무승부로 종료

// 혼자서 선공 후공을 다 맡음
// 혼자서 o,x 표시를 번갈아가면서 표시를 진행한다

// 다음과 같은 규칙을 어기는 실수를 했을수도 있다
// o를 표시할 차례인데 x료 표시하거나, 반대로 x를 표시할 차례인데
// o를 표시한다
// 선공이나 후공이 승리해서 게임이 종료되었음에도 그 게임을 진행한다

// 실제로 틱택토 규칙을 지켜서 진행했을 때 나올수 있는 상황인지는
// 판단할 수 있을 것같고 문제가 없다면 게임을 이어서 가려고 한다

// 게임판이 규칙을 지켜서 틱테토를 진행할 수있는 게임 상황이라면 1
// 없는 상황이라면 0을 리턴하는 함수

class Solution_160585 {
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'O'){
                    oCnt++;
                }
                if(board[i].charAt(j) == 'X'){
                    xCnt++;
                }
            }
        }
        if(xCnt > oCnt || oCnt > xCnt + 1){
            return 0;
        }
        boolean oWin = hasWon(board, 'O');
        boolean xWin = hasWon(board, 'X');

        if(oWin && oCnt != xCnt +1){
            return 0;
        }
        if(xWin && xCnt != oCnt ){
            return 0;
        }
        return 1;
    }

    private boolean hasWon(String[] board, char target) {
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target){
                return true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target){
                return true;
            }
        }
        if(board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target){
            return true;
        }
        if(board[0].charAt(2) ==  target && board[1].charAt(1) == target && board[2].charAt(0) == target){
            return true;
        }
        return false;
    }
}