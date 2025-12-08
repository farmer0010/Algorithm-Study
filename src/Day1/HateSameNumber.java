package Day1;

import java.util.*;

public class HateSameNumber {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (list.size() == 0 || list.get(list.size() - 1) != num) {
                list.add(num);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
