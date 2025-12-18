package Day6;

// 스택으로 풀어야되는걸 gemini 떄문에 알긴아는 상황
// 얘를 어떻게 가지고 놀아야할지 고민해보자
// ()() 이런식으로 들어온다고 생각해보자
// 다음껄 미리 꺼내보는데? )이게 있다면 stack pop을 통해 팅겨줘야하지않나?

import java.util.ArrayDeque;

class ValidParentheses {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else
            {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        boolean answer = stack.isEmpty();
        return answer;
    }
}
