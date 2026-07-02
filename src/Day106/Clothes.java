package Day106;

// 의상

// 코니는 매일 다른 옷을 조합하여 입는 것을 좋아함

// 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있고
// 착용한 의상의 일부가 겹치더라도 다른 의상이 겹치지않거나
// 혹은 의상을 추가로 더 착용한 경우는 서로 다른 방법으로
// 계산함
// 코니는 하루에 최소 1개이상의 옷을 입음

// 우리에게는 clothes 라는 배열이 주어지고
// 의상의 이름, 의상의 종류로 주어짐

// 샌드박스
// 수학적 원리를 생각해보면 모든 옷의 입는 경우의 수를 생각
// 해서 계산하고 모두 안입는 경우 1번만 제외시칸다
// 해시맵에 넣어서 중복을 관리 시키고
// 그 값을 리턴 시키면 되지않을까??

import java.util.HashMap;
import java.util.Map;

class Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (String[] strings : clothes) {
            map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
        }
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
