package Day26;

class NLCM {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int g = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / g;
        }
        return answer;
    }

    // 유클리드 호제법: 나름 자주 나오는 최대 공약수 나올떄 사용하는건데 기억을 못해냈음
    private int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
