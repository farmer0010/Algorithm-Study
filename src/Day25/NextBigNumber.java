package Day25;

class NextBigNumber {
    public int solution(int n) {
        int answer = Integer.bitCount(n);
        while(true)
        {
            n++;
            int temp = Integer.bitCount(n);
            if(answer == temp)
                return n;
        }
    }
}
