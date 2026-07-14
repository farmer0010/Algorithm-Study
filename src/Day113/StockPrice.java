package Day113;

// 초 단위로 기록된 주식 가격이 담긴 배열
// price가 매개변수로 주어질 때 가격이 떨어지지않은
// 기간은 몇초인지  리턴

// 샌드박스
// 가격과 초를 유지할 수 있는 클래스를 만들어야하나 생각?
// 그리고 어떤 자료구조를 써야할지 지문만 보고는 감이 안옴
// 아까 스택으로 힌트를 받았다만 혼자 생각했다면 생각이 안났을 것
// 같은 느낌?

class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length ; j++) {
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
