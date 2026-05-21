package Day88;

// xyz 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여함
// xyz 마트에서는 회원을 대상으로 매일 한가지 제품을 할인하는 행사를 함

// 할인 하는 제품은 하루에 하나씩만 구매 가능
// 그래서 자신이 원하는 제품과 수량이 할인 하는 날짜와 10일 연속으로
// 일치할 경우 회원 가입을 하려고함

// 원하는 제품을 나타내는 want와 수량을 나타내는 number
// xyz마트에서 할인하는 제품 discount, 회원등록시
// 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원 등록일을
// 리턴하는 함수를 만드시오 가능한 날이 없으면 0을 리턴

// 샌드박스:
// 일단 want와 number을 가지고 해시맵으로 만들어서 관리하는게 좋을 것같음
// 그리고 discount 배열을 순회하며 그 값이 있을 때 하나씩 지워주는 느낌으로?
// 근데 원본 hashmap을 사용하면 훼손 되지않을까라는 생각이 들어서
// 하나 더 만들어서 복사해서 사용해야하는 형식으로 가야되나?

import java.util.HashMap;

class Discount {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 일단 메인 맵 완성
        HashMap<String, Integer> mainMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            mainMap.put(want[i], number[i]);
        }
        for (int i = 0;  i <= discount.length - 10; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>();
            for (int j = i; j < i+10; j++){
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0) + 1);
            }

            if(mainMap.equals(tempMap)){
                answer++;
            }
        }
        return answer;
    }
}
