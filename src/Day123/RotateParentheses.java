package Day123;
// 괄호 회전하기

// (), [], {} 는 모두 올바른 괄호 문자열이며
// a가 올바른 괄호 문자열이면 다른 것도 올바른 괄호 문자열임
// 그리고 a,b가 올바른 괄호 문자열이면 a,b도 올바른 괄호 문자열임

// s를 왼쪽으로 x만큼 회전 시켰을 때 올바른 괄호 문자열이 되는 개수를 리턴

// 샌드 박스
// 일단 괄호를 주기적으로 다뤄줘야하기 때문에 스택을 통해서 다뤄줘야할 것같고
// 어떻게 이동 시킨 문자열을 보관하고 다룰지에 관하여 고민해봐야할듯 함

// 그 자리수 만큼 잘라서 뒤에 붙여줘야하는데 이부분에 대하여 어떻게할지만 고민 해봐야할듯함

import java.util.Stack;

class RotateParentheses {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++)
        {
            // 1. 자리수 만큼 잘라서 뒤에 붙여줌
            String newStr = s.substring(i) + s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            boolean isFlag = false;

            for(int j = 0; j < newStr.length(); j++){
                char ch = newStr.charAt(j);

                if(stack.isEmpty() && (ch == ']' || ch == '}' || ch == ')'))
                {
                    isFlag = true;
                    break;
                }

                if(ch == '[' || ch == '(' || ch == '{'){
                    stack.push(ch);
                }
                if(stack.peek() == '[' && ch == ']')
                    stack.pop();
                else if(stack.peek() == '(' && ch == ')')
                    stack.pop();
                else if(stack.peek() == '{' && ch == '}')
                    stack.pop();
                else{
                    isFlag = true;
                    break;
                }
            }

            if(stack.isEmpty() && !isFlag){
                answer++;
            }
        }

        return answer;
    }
}