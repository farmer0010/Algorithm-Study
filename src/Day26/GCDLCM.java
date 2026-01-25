package Day26;

class GCDLCM {
    public int[] solution(int n, int m) {
        int gcdVal = gcd(n, m);
        int lcmVal = (n*m) / gcdVal;

        int[] answer = {gcdVal, lcmVal};
        return answer;
    }
    private int gcd(int a, int b) {
        if(a%b == 0)
            return b;
        return gcd(b, a % b);
    }
}
