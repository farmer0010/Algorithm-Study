package Day17;

import java.util.Stack;

class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < prices.length; i++) {
            // 1. 스택이 비어있지않고(필수)
            // 방금 들어온 가격(price[i])이 '스택 맨위의 시점보다 가격이 떨어졌다면 하락장'
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 스택에서 시점을 뺴고 그 인덱스의 answer = 현재시각 - 들어온 시각
                int entry = stack.pop();
                answer[entry] = i - entry;
            }
            stack.push(i);
        }
        while (!stack.isEmpty())
        {
            int entry = stack.pop();
            answer[entry] = (prices.length-1) - entry;
        }
        return answer;
    }
}
