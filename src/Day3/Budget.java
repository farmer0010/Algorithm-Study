package Day3;

import java.util.Arrays;

class Budget {
    public int solution(int[] d, int budget) {
        int []arr = new int[d.length];
        int count  = 0;
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            arr[i] = d[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum <= budget)
                count++;
            else
                break;
        }
        int answer = count;
        return answer;
    }
}
