package Day36;

// 1. 양의 정수 n이 주어지고 k 진수로 바꿨을때
// 변환된 수에 소수가 몇개인지?
// 2. 조건
// 1. 0p0 처럼 소수 양쪽에 0이 있는 경우
// 2. p0, 0p 처럼 소수 좌측에는 있고 오른쪽에는 없고
// 소수 우측에는 있고 좌측에는 아무것도 없는 경우
// 3. p처럼 소수 양쪽에 아무것도 없는 경우
// 단 p는 각자릿수에 0을 포함하지않는 소수이다
// 문제풀이
// Integer.toString으로 진수 변환후
// 위에 말한 조건이 spilt으로 어떻게 쪼개질 핵심 아닐까?
// 그 이후 조건을 따져야할것같은데 자리수로 체크?
// 그 이후 Math.sqrt()로 소수인지 아닌지 체크하고 맞다면
// ++해주면될듯
// 빈문자열이나 1같은 숫자가 들어오면 그냥 return 0?

class KPrimeCount {
    public int solution(int n, int k) {
        int answer = 0;
        // 일단 진수 변환
        String convertN = Integer.toString(n, k);
        String[] primeStr = convertN.split("0");
        for (String str : primeStr) {
            if(isPrime(str))
            {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(String str) {
        if(str.isEmpty() || Long.parseLong(str) == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(Long.parseLong(str)); i++) {
            if((Long.parseLong(str)) % i == 0)
                return false;
        }
        return true;
    }
}
