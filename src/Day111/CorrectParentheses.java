package Day111;

// 올바른 괄호

// 괄호가 바르게 짝지어졌다는 것은 ( 문자가 열렸으
// 면 반드시 짝지어서 ) 문자로 닫혀야한다는 뜻이다.
// (, ) 로만 이루어진 문자열 s가 주어졌을 때 문자열 s
// 가 올바른 괄호이면 true를 리턴, 올바르지않은 괄호면
// false를 리턴하도록 하시오

// 샌드박스
// 1. 적재해뒀다가 꺼내쓰는 식으로 하려면 스택 구조를
// 사용해야할 것같은데 또 들어간게 먼저 나와야되기도 하니깐
// 스택이랑 큐중 어떤 걸 써야할지 이건 코드를 짜보며 생각해보자
// 근데 넣고 빼고 넣고 빼고 하면 스택이 맞음 방금 큐로
// 코드를 짜려니 도저히 각이 안나옴
// 2. 무조건 시작은 ( 로 시작을 해야지 올바른 괄호로 시작됨
// 그리고 개수가 무조건 같다고 맞는 처리가 아님을 인지

import java.util.Stack;

class CorrectParentheses {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            }
            else{
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
