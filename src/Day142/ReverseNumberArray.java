package Day142;

import java.util.ArrayList;

class ReverseNumberArray {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();

        while(n > 0){
            int k = (int)(n % 10);
            list.add(k);
            n = n / 10;
        }

        int answer[] = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
