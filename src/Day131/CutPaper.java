package Day131;

// 종이 자르기

// 1 * 1 크기로 종이를 자르려고하고 2 * 2 크기 종이르 1*1 크기로 자르려면 최소
// 가위질 세번이 필요하다.
// 정수 M,N이 주어졌을 때 M,N 크기의 종이를 최소 가위질 해야하는 횟수를 리턴

class CutPaper {
    int answer = 0;
    public int solution(int M, int N) {
        answer = cut(M,N);
        return answer;
    }


    private int cut(int M, int N){
        int cnt = 0;

        if(M == 1){
            return cnt + N -1;
        }
        cnt += N + cut(M-1, N);
        return cnt;
    }
}
