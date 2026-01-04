package Day14;

class MinRectangle {
    public int solution(int[][] sizes) {
        // 1. 규칙 세우기
        int findMaxW = 0;
        int findMaxH = 0;

        for (int[] card : sizes) {
            int w = card[0];
            int h = card[1];

            int big = Math.max(w,h);
            int small = Math.min(w,h);

            if(big > findMaxW){
                findMaxW = big;
            }
            if(small > findMaxH){
                findMaxH = small;
            }
        }
        int answer = findMaxW * findMaxH;
        return answer;
    }
}
