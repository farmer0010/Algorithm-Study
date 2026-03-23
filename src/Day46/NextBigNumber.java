package Day46;

// 뒤에 있는 큰 수 찾기
// 배열의 각 원소에 대해 자신 보다 뒤에 있는
// 숫자중에서 자신보다 크면서 가장 가까이 있는 수를
// 뒷 큰수라고 한다

// 샌드박스
// 메이커가 무기에 힌트를 주기를 가장 최근에
// 대기한 애들부터꺼내야함? 그러면 스택이지
// 스택안에는 인덱스 위치를 넣어야 섞이지않기떄문에
// 인덱스 위치를 넣는다?

import java.util.Arrays;
import java.util.Stack;

class NextBigNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(answer, -1);
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int top = stack.pop();
                answer[top] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}
