package Day39;

// 할인행사
// 마트에서 일정한 금액을 지불하면 10일 동안 회원 자격 부여
// 매일 한가지 제품을 할인 진행중 -> 할인하는 제품은 하루에 하나씩만 구매가능
// 자신이 원하는 제품과 할인하는 날짜가와 10일 연속으로 일치할경우 맞쳐서 회원가입

// want 원하는 상품, number는 원하는 물품의 갯수, discount는  할인하는
// 제품 문자열 배열
// 리턴 값은 원하는 제품을을 할인 받을 수있는 총 일수
// 가능한 날이 없으면 0을 리턴

// 샌드박스
// 원하는 물품과 일단 갯수를 맵구조로 맞쳐줘야 할듯?
// 일단 만든 맵의 키값과 discount 배열과 일치하고 갯수를 줄이는 방식으로
// 근데 이게 10번동안 되지않았다면 answer을 증가시키지않음 (반복문?)

// 개선점: 나의 목표인 맵을 만들고 discount 배열을 만들며 개수를 구하는 맵을
// 만들고 두개의 맵을 활용 , map에도 equals가 존재하여 종류와 개수 비교가능

import java.util.HashMap;
import java.util.Map;

class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> mainMap = new HashMap<String, Integer>();

        // 일단 원하는 물품과 갯수를 닮은 배열 생성
        for (int i = 0; i < want.length; i++) {
            mainMap.put(want[i], number[i]);
        }

        // 14일 진행하기떄문에 각자 케이스에 맞는 걸 생성후 같은지 확인?
        // 근데 이렇게하면 갱신 되나보니깐 위험성이 있으니 저 submap을 담
        // 을수 있는 배열을 만들어야하나?? 생각이 들긴함
        for (int i = 0; i <= discount.length - 10; i++)
        {
            Map<String, Integer> subMap = new HashMap<>();
            for(int j = i; j < i+10; j++ )
            {
                subMap.put(discount[j], subMap.getOrDefault(discount[j], 0) + 1);
            }
            if(mainMap.equals(subMap))
                answer++;
        }
        return answer;
    }
}