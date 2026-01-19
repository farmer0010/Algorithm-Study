package Day21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Rollcake {
    public int solution(int[] topping) {
        int answer = 0;
        // 1. 모든 토핑은 형의 map에 담아두기 (토핑 이름, 토핑 t의 갯수)
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        // 2. 동생은 종류만 중요하니 set(중복 제거)
        Set<Integer> leftSet = new HashSet<>();
        for (int t : topping) {
            leftSet.add(t);
            rightMap.put(t, rightMap.getOrDefault(t, 0) - 1);
            if(rightMap.get(t) == 0)
                rightMap.remove(t);
            if(rightMap.size() == leftSet.size())
                answer++;
        }
        return answer;
    }
}
