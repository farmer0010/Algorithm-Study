package Day141;

// 자연수 n이 매개변수로 주어지고 n을 3진법 상에서 앞으로 뒤집은후 이를 다시
// 10진법으로 표현

// 일단 3진법은 변환함수가 없어서 직접 변환해야함
// 근데 생각한게 애초에 3진법으로 변환하는 과정에서
// 나머지를 스트링 빌더로 붙여버리면 애초에 앞뒤 반전한 상태로 나오는게 맞지않나?
// 라고 생각함

class ReverseTernary {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int mod = n % 3;
            sb.append(mod);

            n /= 3;
        }

        String ans = sb.toString();

        for(int i = 0; i < ans.length() ; i++){
            char ch = ans.charAt(ans.length() - 1 - i);
            int num = ch - '0';

            answer += num * (int)Math.pow(3, i);

        }

        return answer;
    }
}
