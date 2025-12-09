package Day2;

import java.util.ArrayDeque;
import java.util.Deque;

class CorrectParentheses {
    boolean solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        boolean answer = stack.isEmpty();
        return answer;
    }
}
