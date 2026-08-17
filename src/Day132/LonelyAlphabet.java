package Day132;

// 외톨이 알파벳

// 알파벳 소문자로만 이루어진 어떤 문자열에서 2회이상 나타낸 알파벳이 2개 이상의 부분으로
// 나누어져있으면 외톨이 알파벳이라고 정의한다.

// 샌드박스
// 일단 2회이상 나타면서 알파벳이 2개 이상 나오는걸 우리가 어떻게 추론해볼까 생각해봐야함
// 일단 생각이 든건 hashMap으로 관리할건데 (알파벳 순 생각하면 treemap 쓰자) 예를 들어 하나의 알파벳 a,b,c 이런거러면 맵에 넣음
// 근데 aa, bbb, cc 이렇게 같은 문자가 연속된 경우엔 얘네를 따로 넣지말고 묶어서 넣어버림
// 그리고 개수가 2개이상인 애들을 뽑아내면 나올듯한데

import java.util.*;

class LonelyAlphabet {
    public String solution(String input_string) {
        Map<Character, Integer> alone_map = new TreeMap<>();

        int i = 0;
        int n = input_string.length();
        StringBuilder sb = new StringBuilder();

        while(i < n){
            int j = i;

            while(j < n && (input_string.charAt(i) == input_string.charAt(j)))
                j++;
            alone_map.put(input_string.charAt(i), alone_map.getOrDefault(input_string.charAt(i), 0) +1);

            i = j;
        }

        for(Map.Entry<Character, Integer> entry : alone_map.entrySet()){
            if(entry.getValue() >= 2)
                sb.append(entry.getKey());
        }

        String answer = sb.toString();

        if(answer.equals(""))
            answer = "N";

        return answer;
    }
}
