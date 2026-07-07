package Day108;

// 올바른 괄호

// 괄호가 바르게 짝 지어져있다는 것은 ( 문자로 열렸으면
// 반드시 짝 지어서 )  문자로 닫혀있다는 뜻임
// 문자열 s가 올바른 괄호이면 true를 리턴
// 올바르지않은 괄호라면 false를 리턴

// 샌드 박스
// 1. 스택을 가지고 해결해야하는데 어떻게 올바른 괄호로
// 판단할 것인지가 관건
// 2. 스택 하나로만 이게 해결 가능한지 아니면
// 추가적인 요건이 있어야하는지 그것도 판단 필요

import java.util.Stack;

class CorrectParentheses {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        boolean answer = stack.isEmpty();

        return answer;
    }
}
