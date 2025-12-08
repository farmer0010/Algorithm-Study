package Day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PickTwoAndAdd {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                set.add(num);
            }
        }
        for (Integer i : set) {
            new ArrayList<Integer>().add(i);
        }
        new ArrayList<Integer>().sort(Integer::compare);
        int[] answer = new int[new ArrayList<Integer>().size()];
        for(int i = 0; i < new ArrayList<Integer>().size(); i++) {
            answer[i] = new ArrayList<Integer>().get(i);
        }
        return answer;
    }
}
