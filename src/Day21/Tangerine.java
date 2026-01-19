package Day21;

// Hashmap 구조를 통해서 크기당 갯수를 파악하고 정렬

import java.util.*;

class Tangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 사이즈별로 갯수 세기 (map.getOrDefault 활용)
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 우리에게 필요한건 갯수이니깐 갯수를 인지
        List<Integer> count = new ArrayList<>(map.values());
        // 수 정렬 이후 역으로 뒤집어서 가장 큰수부터
        count.sort(Collections.reverseOrder());
        // 갯수 많은 귤부터 담기, 종류가 최소여야하니깐
        for (Integer t : count) {
            if(k > 0)
            {
                answer++;
                k -= t;
            }
        }
        return answer;
    }
}
