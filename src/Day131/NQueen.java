package Day131;

// n-queen

class NQueen {
    int answer = 0;
    int g_col[];
    public int solution(int n) {

        g_col = new int[n];

        solve_nqueen(0, n);

        return answer;
    }

    private void solve_nqueen(int col, int n){
        if(col == n){
            answer++;
            return;
        }
        for(int row = 0; row < n; row++){
            if(is_safe(col, row)){
                g_col[col] = row;
                solve_nqueen(col +1, n);
            }
        }
    }

    private boolean is_safe(int col, int row){
        int diff_row;
        int diff_col;
        int prev_row;
        int prev_col;

        prev_col = 0;

        while(prev_col < col){
            prev_row = g_col[prev_col];

            if(prev_row == row)
                return false;

            diff_row = row - prev_row;
            diff_col = col - prev_col;

            if(diff_col == diff_row || diff_col == -diff_row)
                return false;

            prev_col++;
        }
        return true;
    }
}
