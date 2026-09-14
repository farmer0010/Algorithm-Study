package Day143;

// 문자열 내림차순 배치하기

// 일단 대문자 배열과, 소문자 배열을 분류하여 담고
// Collections.reverseOrder()를 통해 역으로 순환

import java.util.*;

class StringDescendingOrder {
    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        ArrayList<Character> listL = new ArrayList<>();
        ArrayList<Character> listR = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isUpperCase(ch)){
                listR.add(ch);
            }
            else if(Character.isLowerCase(ch)){
                listL.add(ch);
            }
        }

        listL.sort(Collections.reverseOrder());
        listR.sort(Collections.reverseOrder());

        for(int i = 0; i < listL.size(); i++){
            sb.append(listL.get(i));
        }

        for(int i = 0; i < listR.size(); i++){
            sb.append(listR.get(i));
        }

        answer = sb.toString();

        return answer;
    }
}
