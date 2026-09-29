package Day148;

// 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수있는 가장 큰 숫자를 구하려고함

// 예를 들어 수 2개를 제거하면 여러가지 조합이 나옴
// number에서 k개의 숫자를 제거했을때 만들 수있는 가장 큰 수를 문자열 형태로 리턴

import java.util.*;

class MakeBigNumber {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < number.length(); i++){
            char ch = number.charAt(i);
            int n = ch - '0';

            while(!stack.isEmpty() && stack.peek() < n && k > 0){
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        StringBuilder sb = new StringBuilder();

        while(k > 0){
            stack.pop();
            k--;
        }

        while(!stack.isEmpty()){
            int n = stack.pop();
            sb.append(n);
        }

        String str = sb.toString();

        sb = new StringBuilder();

        for(int i = str.length() -1; i >= 0; i--){
            sb.append(str.charAt(i));
        }

        answer = sb.toString();

        return answer;
    }
}
