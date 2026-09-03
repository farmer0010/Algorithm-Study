package Day139;

// 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지않고 그대로 인 문자열 s가
// 매개변수로 주어짐 s가 의미하는 원래 숫자를 리턴 하도록 함수를 완성해라

// 샌드 박스
// 1. for문으로 일단 s 문자열을 돌리는데 일단 알파벳인지 숫자는 판단을 해야함
// 2. 근데 문제가 뭐냐? 문자열이 숫자로 어떻게 변환되는지 판별이 필요함
// 일단 영어를 숫자로 변환한거의 글자수는 최소 3개에서 최대 5개임
// 그래서 문자열의 길이가 3일때, 4일때, 5일때에 맵의 키가 일치하는게 있는지
// 확인하고 일치하다면 그게 값이니깐 그걸 넣어주면 될것같은데?
// 3. 숫자에 대응하는 영단어 표는 맵 구조에다가 보관해두고 불러오면 될것같음
// 문자가 k 숫자가 v

import java.util.*;

class NumberStringAndWord {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder total = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);

            if(Character.isDigit(ch)){
                total.append(ch);
            }
            else {
                sb.append(ch);
                if(sb.length() > 2){
                    if(map.containsKey(sb.toString())){
                        total.append(map.get(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }
        }
        answer = Integer.parseInt(total.toString());

        return answer;
    }
}
