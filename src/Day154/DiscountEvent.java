package Day154;

// 할인행사
// 일정 금액 지불하면 10일동안 회원 자격 부여
// 마트에서 회원을 대상으로 할인하는 제품을 하루에 한가지씩 구매가능
// 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치하는 경우에 맞쳐서 회원가입하려고함

// 샌드박스
// 일단 want와 number를 통해 맵을 만들고
// discount도 맵으로 만들되 10개씩 잘라서 이 두개의 맵이 같은지 비교하는 형식으로 가야할듯함

import java.util.*;

class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> mainMap = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            mainMap.put(want[i], number[i]);
        }

        for(int k = 0; k <= discount.length - 10 ; k++){
            HashMap<String, Integer> subMap = new HashMap<>();
            for(int n = 0; n < 10; n++){
                subMap.put(discount[n +k], subMap.getOrDefault(discount[n+k], 0) + 1);
            }

            if(mainMap.equals(subMap)){
                answer++;
            }
        }

        return answer;
    }
}
