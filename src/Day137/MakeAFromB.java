package Day137;

// A로 B만들기

// 문자열 before과 after가 매개변수로 주어질 때
// before 순서를 바꾸어 after을 만들수있으면 1을 아니면 0을 리턴

import java.util.*;

class MakeAFromB {
    public int solution(String before, String after) {
        int answer = 0;
        Map<Character, Integer> before_map = new HashMap<>();
        Map<Character, Integer> after_map = new HashMap<>();

        for(int i = 0; i < before.length(); i++){
            before_map.put(before.charAt(i),before_map.getOrDefault(before.charAt(i),0) + 1) ;
            after_map.put(after.charAt(i) ,after_map.getOrDefault(after.charAt(i),0)+ 1);
        }

        if(before_map.equals(after_map)){
            return 1;
        }

        return answer;
    }

}