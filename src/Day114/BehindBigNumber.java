package Day114;

// 뒤에 있는 큰 수 찾기

// 정수로 이루어진 배열 numbers가 있다
// 배열의 각 원소들에 대해 자신보단 뒤에 있는 숫
// 자중에서 자신 보다 크면서 가장 가까이 있는 수를
// 뒤 큰수라고 함
// 정수 배열 numbers가 매개변수로 주어질 때
// 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을
// return 단 뒷 큰수보다 큰수가 존재하지않는다면
// 원소는 -1을 담음
// 이거는 뒤에 자기보다 큰수를 못참는 경우를 생각해서
// 일반 이 배열을 -1로 채워두는 거임
// 그러고 저거 작업 시작

// 샌드 박스 일단 가장 큰수를 찾아야

import java.util.Arrays;
import java.util.Stack;

class BehindBigNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(answer, -1);
        for(int i = 0; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int top = stack.pop();
                answer[top] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}
