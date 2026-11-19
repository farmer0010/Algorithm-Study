package Day169;

// 짝 지어 제거하기

// 알파벳 소문자로 이루어진 문자열을 가지고 시작
// 문자열에서 같은 알파벳이 2개 붙어있는 짝을 찾고 그 둘을 제거한뒤
// 앞뒤로 문자열을 이어 붙임
// 다 비어있다면 리턴 1, 아닐 경우 0을 리턴

// 이건 stack으로 하면 될것같은데 어차피 새로 제거한 문자열을 이어 붙일 경우 없이
// stack으로 처리 가능하다고 생각함

import java.util.Stack;

class RemovePairs
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(!stack.isEmpty() && ch == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(ch);
            }

        }

        if(stack.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}
