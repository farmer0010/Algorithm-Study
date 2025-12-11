package Day4;

import java.util.HashMap;
import java.util.Map;

class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        // 여기까지 단계가 map에다가 종류의 개수를 세준거
        for (int i = 0; i < clothes.length; i++) {
            String s = clothes[i][1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Integer value : map.values()) {
            answer *= (value +1);
        }


        return answer - 1;
    }
}
