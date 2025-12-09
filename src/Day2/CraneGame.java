package Day2;

// 2차원 배열과 스택

import java.util.ArrayDeque;
import java.util.Deque;

class CraneGame {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int move : moves) {
            int col = move -1;
            for (int row = 0; row < board.length; row++) {
                int doll = 0;
                if (board[row][col] != 0) {
                    doll = board[row][col];
                    if(stack.isEmpty())
                        stack.push(doll);
                    else if(stack.peek() == doll)
                    {
                        sum += 2;
                        stack.pop();
                    }
                    else
                        stack.push(doll);
                    board[row][col] = 0;
                    break;
                }
            }
        }
        int answer = sum;
        return answer;
    }
}
