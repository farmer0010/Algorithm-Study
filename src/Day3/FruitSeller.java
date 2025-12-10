package Day3;

import java.util.Arrays;

class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int boxCount = score.length / m;
        int sum = 0;
        // 1, 2, 3, 1, 2, 3, 1
        Arrays.sort(score);
        // 1, 1, 1, 2, 2, 3, 3
        if(boxCount == 0)
            return 0;
        for(int i = 1; i <= boxCount ; i++)
        {
            int i1 = score[score.length - (i*m)];
            int temp = i1 * m;
            sum += temp;
        }
        int answer = sum;
        return answer;
    }
}
