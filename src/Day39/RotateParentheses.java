package Day39;

// [], {}, () 이게 올바른 괄호이자 문자열
// 근데 문자열 길이만큼 왼쪽으로 0부터 s.length까지 이동 시킬 때
// 몇개의 올바른 문자열이 나오는지 갯수를 세는 문제

// 샌드박스
// 원래 전에는 괄호로 짝을 맞출 때 stack을 사용했던거같은데?
// 문자열을 자르고 이걸 어떻게 조합 시키며 이동할지 생각을 한번 해보자

import java.util.Stack;

class RotateParentheses {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVaild(s))
            {
                answer++;
            }
            s = s.substring(1) + s.substring(0,1);
        }

        return answer;
    }

    private boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[')
                stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char top = stack.peek();

                if(c == ')' && top == '(')
                    stack.pop();
                else if(c == '}' && top == '{')
                    stack.pop();
                else if(c == ']' && top == '[')
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
