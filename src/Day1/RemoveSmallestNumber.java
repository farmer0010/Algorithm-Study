package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RemoveSmallestNumber {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        if(arr.length == 1)
        {
            return new int[]{-1};
        }

        for (int num : arr) {
            list.add(num);
        }
        int min = Collections.min(list);
        // 이게 list의 가장 작은 수를 찾아주는 거같은데?
        int index = list.indexOf(min);
        list.remove(index);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
