package Day129;

// 주식 가격

// 초 단위로 기록된 주식 가격이 담긴 배열 prices가 매개변수로 주어질 때 가격이 떨어지지 않는
// 기간은 몇초인지를 리턴 하도록 함수를 작성

// 샌드박스 
// 단순 반복문으로 하면 저 길이를 가지고 돌리면 무조건 터진다
// 스택으로 하면 저 늘어나는 초 유지를 어떻게 할까?를 생각해보자

import java.util.Stack;

class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for(int i = 1; i < prices.length ; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int n = stack.pop();
                answer[n] = i - n;
            }
            stack.push(i);
        }

        while(! stack.isEmpty()){
            int n = stack.pop();
            answer[n] = (prices.length -1) - n;
        }

        return answer;
    }
}