package Day53;

// 짝 지어 제거하기
// 알파벳 소문자로 이루어진 문자열을 가지고 시작
// 문자열에서 같은 알파벳이 2개 붙어있는 짝을 찾고
// 그 둘을 제거한 뒤 문자열을 이어붙임

// 성공적으로 제거할 수 있으면 1
// 아니면 0

import java.util.ArrayDeque;
import java.util.Deque;

class PairRemoval
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
