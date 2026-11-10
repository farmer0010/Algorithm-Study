package Day165;

// 0 또는 양의 정수가 주어졌을떄 정수를 이어 붙여 만들수 있는
// 가장 큰수를 알아내라

// 일단 주어진 수가 1000이하니깐 재귀나, dfs를 통해 모든 조합의 수를
// 구하는 방식이 생각이 들고 -> 길이의 오해 원소의 크기가 0이상 1000이하임
// 저거를 아스키 순으로 배열해보는 것도 괜찮겠다라고 생각함

import java.util.ArrayList;
import java.util.Collections;

class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = "";

        ArrayList<String> lst = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            lst.add(String.valueOf(numbers[i]));
        }

        Collections.sort(lst, (a,b) -> {
            return (a+b).compareTo(b+a);
        });

        StringBuilder sb = new StringBuilder();

        for(int i = lst.size() -1 ; i >= 0; i--){
            sb.append(lst.get(i));
        }
        answer = sb.toString();

        if(answer.charAt(0) == '0'){
            return "0";
        }

        return answer;
    }
}
