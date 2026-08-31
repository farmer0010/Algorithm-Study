package Day138;

// 짝 지어 제거하기

// 먼저 문자열에서 같은 알파벳이 2개 붙어있는 짝을 찾고
// 그 다음 그 둘을 제거한 뒤 앞뒤로 문자열을 이어 붙임

// 이 과정을 반복해서 문자열을 모든 제거한다면 짝 지어 제거하기는 종료

import java.util.Stack;

class RemovePairs
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);

            if(!stack.isEmpty() && ch == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        if(stack.isEmpty())
            answer = 1;

        return answer;
    }
}
