package Day143;

// 중복된 문자 제거

// 문제를 풀다가 고민점
// set은 순서보장이 안되는데 이문제는 어떻게 해결할것인가?
// 정렬된 순서가 필요하다고 하면 해시셋이 필요하다는것 알았고
// 여기서 입력 순서를 지키려면 링크드 해시셋을 이용한다는것을 추가적으로 배움

import java.util.Collections;
import java.util.LinkedHashSet;

class RemoveDuplicateCharacter {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for(int i = 0; i < my_string.length(); i++){
            char ch = my_string.charAt(i);
            set.add(ch);
        }

        for(Character c : set){
            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}
