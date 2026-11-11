package Day166;

// 초 단위로 기록된 주식 가격이 담긴 배열이 주어질 때
// 가격이 떨어지지 않은 기간은 몇초인지를 리턴

// 스택을 통해 보관하는데 안에 있는 들어가 있는 값을
// 집어 넣기보다 인덱스를 통해 어느정도 유지되는 (초) 느낌으로 관리하는 느낌
// 언제 들어가고 언제 빠지는지를 계산하는 부분이 필요

import java.util.*;

class StockPrice {
    public int[] solution(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int n = stack.pop();
                int time = i - n;
                answer[n] = time;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int n = stack.pop();
            int time = prices.length - n - 1;
            answer[n] = time;
        }

        return answer;
    }
}
