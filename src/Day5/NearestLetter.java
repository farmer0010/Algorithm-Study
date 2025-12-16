package Day5;

// 처음 나오는건 -1로 표현
// 같은 문자일 떄 처음 등장한 인덱스와 다음으로 나온
// 차이 값을 리턴? 또 나왔을 경우 이중 가까운걸 리턴
// 데이터를 계속 덮어쓴다는 개념이 중요

import java.util.HashMap;
import java.util.Map;

class NearestLetter {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(! map.containsKey(c))
            {
                answer[i] = -1;
            }
            else
            {
                answer[i] = i - map.get(c);
            }
            map.put(c, i);
        }
        return answer;
    }
}