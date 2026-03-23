package Day55;

// 괄호
// 괄호문자열 ps는 두개의 괄호 기호로 구성
// 그중에서 괄호 문자열이 바르게 구성된 문자열을 vps라고함
// 만약에 x가 vps라면 이것을 하나의 괄호에 넣은 문자열도vps라고함

// 입력 데이터는 표준 입력
// 각 테스트의 데이터의 첫째줄에는 괄호 문자열이 한줄에 이어짐
// 입력 데이터는 T

// 스택을 통해 가지고 놀아야할듯?

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();

            Deque<Character> stack = new ArrayDeque<>();
            Boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if(ch == '(')
                    stack.push(ch);
               else if(ch == ')')
                {
                    if(stack.isEmpty())
                    {
                        flag = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if(flag && stack.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
