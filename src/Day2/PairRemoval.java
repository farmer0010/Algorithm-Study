package Day2;

import java.util.ArrayDeque;

public class PairRemoval {
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if(stack.isEmpty())
            {
                stack.push(c);
            }
            else if(stack.peek() == c)
            {
                stack.pop();
            }
            else
                stack.push(c);
        }
        int answer = stack.isEmpty() ? 1 : 0;
        return answer;
    }
}
