package Day13;

// 1. 숫자를 문자로 바꾸고
// 2. compareTo를 통해서 자리 비교

import java.util.Arrays;

class BiggestNumber {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNums, (o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });
        if(strNums[0].equals("0")){
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for (String strNum : strNums) {
            answer.append(strNum);
        }
        return answer.toString();
    }
}
