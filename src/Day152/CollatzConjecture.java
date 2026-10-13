package Day152;

// 샌드박스

// 규칙
// 1-1 입력된 숫자가 짝수라면 2로 나누고
// 1-2 입력된 수가 홀수라면 3을 곱하고 1을 더한다
// 2. 결과로 나온수에 같은 작업을 1일 될떄까지 반복

class CollatzConjecture {
    public int solution(int num) {
        int answer = 0;

        long n = (long)num;

        if(n == 1)
            return 0;

        while(n != 1){
            if(answer >= 500)
                return -1;

            if(n % 2 == 0){
                n /= 2;
            }
            else{
                n = (n * 3) + 1;
            }
            answer++;
        }

        return answer;
    }
}
