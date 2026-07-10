package Day112;

// 숫자의 표현
// 자연수 n을 연속한 자연수들로 표현하는 방법이
// 여러개 있음
// 연속된 자연수들로 n을 표현하는 방법의 수를 리턴

// 샌드박스
// 뭔가 처음부터 경우의 수를 세보다 보면 규칙이 있지않을까?
// 라고 생각해보며 앞에 경우의 수를 세봤지만 특정적인 규칙이
// 없었음
// n은 총 10000개 이다 보니 직접 돌려봐도 안꺠지지 않을까?
// 라는 생각이 조금은 드는 상태이고

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=i;j <= n;j++){
                sum += j;
                if(sum == n){
                    answer++;
                    break;
                }
                else if(sum > n){
                    break;
                }
            }
        }

        return answer;
    }
}
