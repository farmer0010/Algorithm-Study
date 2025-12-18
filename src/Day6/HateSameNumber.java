package Day6;

// 일단 값을 가지고 놀려면 arr 배열에 있던걸 stack에 넣고
// 스택에서 어떻게 연속된 수를 처리할건지 생각해봐야할듯
// 애초에 검사를 하면서 넣으면 되지않나?

import java.util.*;

public class HateSameNumber {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if(stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
