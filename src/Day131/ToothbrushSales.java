package Day131;

// 다 단계 칫솔

import java.util.HashMap;

class ToothbrushSales {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parentMap = new HashMap<>();
        HashMap<String, Integer> sonMap = new HashMap<>();

        for(int i = 0; i < enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            sonMap.put(enroll[i], 0);
        }

        for(int i = 0; i < seller.length; i++){
            int sell_money = amount[i] * 100;

            distribute(seller[i], sell_money, parentMap, sonMap);
        }

        int[] answer = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++){
            answer[i] = sonMap.get(enroll[i]);
        }

        return answer;
    }

    private void distribute(String cur, int sell_money, HashMap<String, String> parentMap, HashMap<String, Integer> sonMap){

        // 종료조건 루트 노트를 만나거나 이익이 1원 보다 낫거나
        if(cur.equals("-") || sell_money <= 0){
            return;
        }

        int commision = sell_money / 10;
        int private_money = sell_money - commision;

        sonMap.put(cur, sonMap.get(cur) + private_money);

        String parent = parentMap.get(cur);
        distribute(parent, commision, parentMap, sonMap);
    }
}
