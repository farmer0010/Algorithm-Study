package Day85;

// 어떤 수에서 k개의 수를 제거 할떄 얻을 수 있는 가장 큰 수를
// 구하려고한다
// 문자열 형식으로 숫자 number와 제거할 수의 개수 k가
// 매개 변수로 들어올 때 만들 수 있는 가장 큰 숫자를 문자열
// 형태로 리턴 해야함

// 모든 조합을 따지자니 숫자가 커지면 말도 안되는 조합의 수가 나옴
// 그래서 첫째 자리를 구하고 매번 최선의 수를 구해야하는데
// 이걸 어떻게 생각해야될까?

import java.util.Stack;

class MakeLargestNumber {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);

            while(!stack.isEmpty() && stack.peek() < ch && k > 0){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size() - k; i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
