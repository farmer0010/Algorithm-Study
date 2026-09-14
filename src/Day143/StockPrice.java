package Day143;

// 초 단위로 기록된 주식 가격이 담긴 배열 price가 매개변수로 주어질 때 가격이 떨어지지않은 기간은
// 몇초인지를 리턴하도록 함수를 완성해라

// 샌드박스
// 매번 헷갈리는 부분이지만 스택에 이 떨어지지 않는 시간을 어떻게 관리할까?
// 매번 증가시키고 반복문으로 비교하려면 시간에서 터짐

import java.util.Stack;

class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;  i < prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int len = stack.pop();
                answer[len] = i -len;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int len = stack.pop();
            answer[len] = (prices.length-1) - len;
        }

        return answer;
    }
}
