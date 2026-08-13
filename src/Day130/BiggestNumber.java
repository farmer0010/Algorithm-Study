package Day130;


// 가장 큰 수

// 0 또는 양의 정수가 주어졌을 때 정수를 이어 붙여 만들 수 있는 가장 큰수를 알아보자
// numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를
// 문자열로 바꾸어 리턴하도록 하시오

// 샌드박스 무작정으로 모든 조합의 수를 만들어보기에는 저 배열이 너무 큼
// 일단 stringBulider로 붙여야 할 것같고
// 이걸 비교하자면 저건 그 수 자체로 보면 안되고 아스키 값으로 비교하여 큰수를 뽑아올떄
// 가장 큰 수가 만들어진다
// 정렬을 어떻게 시킬지 고민을 해봐야한다. 또 아닌거같기도하고 접두사로 볼떄 길이가 길면 또 걔가
// 더 큰거니깐 아스키값을 이용하되 같은 접두사에서 길이가 긴 경우도 봐야되겠음

import java.util.*;

class BiggestNumber {
    public String solution(int[] numbers) {
        String[] str_num = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        String answer = "";

        for(int i = 0; i < numbers.length; i++){
            str_num[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str_num, (a, b) -> {
            return (b+a).compareTo(a+b);
        });

        if(str_num[0].equals("0"))
        {
            answer = "0";
            return answer;
        }

        for(int i = 0; i < str_num.length; i++){
            sb.append(str_num[i]);
        }

        return sb.toString();
    }
}
