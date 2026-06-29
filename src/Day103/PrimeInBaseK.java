package Day103;

// k 진수에서 소수 개수 구하기

// 양의 정수 n이 주어지고 이 숫자를 k진수로 바꿨을 때
// 변환 된 수안에 아래 조건에 맞는 소수가 몇개인지 찾으려고함

// 조건 1: 0P0 처럼 소수 양쪽에 0이 있는 경우
// 조건 2: P0처럼 소수 오른쪽에만 0이 있고 왼쪽에 아무것도 없는 경우
// 조건 3: 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
// 조건 4: P처럼 소수 양쪽에 아무것도 없는 경우

// 샌드박스
// 단계별로 생각해보자
// 1. n을 일단 k 진수에 맞게 변환 시키고
// 2. 위에 조건에 맞게 파싱하여 P를 찾아 분리
// 3. 파싱한 숫자가 소수 인지 판별하고 소수가 맞다면 카운팅

class PrimeInBaseK {
    public int solution(int n, int k) {
        int answer = 0;
        // 1단계 진법 변환
        String base = Long.toString((long)n, k);

        // 2단계 조건에 맞게 파싱
        String[] nums = base.split("0");

        for (String num : nums) {
            if(num.equals("1") || num.equals("")){
                continue;
            }
            else{
                if(isPrime(num)){
                    answer++;
                }
            }
        }


        return answer;
    }

    private boolean isPrime(String num) {
        long n = Long.parseLong(num);

        for(long i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
