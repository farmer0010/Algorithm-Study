package Day4;

import java.util.HashMap;

class DidNotFinish {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        // 돌면서 출석부 인원 세기 동명이인 있을 수도 있으니
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // 지금 map에는 string 값과 integer 값으로 개수가 세진 상태
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        // 완주 인원은 이름이 들어간 상태
        for (String s : map.keySet()) {
            if(map.get(s) > 0)
            {
                answer = s;
                break;
            }
        }
        return answer;
    }
}
