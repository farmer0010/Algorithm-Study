package Day104;

// 뉴스 클러스터링

// 문제상황
// 비슷비슷한 제목 기사가 많아 정작 필요한 기사를 찾기가 어려움
// 그래서 사용자들이 편리하게 다양한 뉴스를 찾아볼수 있도록
// 문제점을 개선해야함
// 그렇기 떄문에 유사한 기준을 묶는 기준을 정하기 위해
// 자카드 유사도라는 방법을 사용할 예정

// 자카드 유사도는 집합간의 유사도를 검사하는 여러 방법중
// 하나로 알려져있고 두 집합 a,b 사이의 자카드 유사도
// j(a,b)는 두 집합의 교집합 크기 / 두 집합의 합집합의 크기로 나눈 값
// 이 유사도는 원소의 중복을 허용하는 다중 집합으로 확장 가능
// 다중집합의 경우엔 같은 중복된 숫자의 교집합은 두집합의 min
// 합집합은 max로 처리하면 됨

// 문자열 사이의 유사도를 계산할때 두글자씩 끊어서 만들수 있도
// 위와 같은 방법으로 처리하면 된다 (대문자 소문자 차이 무시)
// 그리고 영문자로 된 글자 쌍만 유사하고 다른 기호가 오면
// 그 쌍을 버린다.
// 그리고 유사도는 0~1사이의 실수 이므로 65536
// 를 곱하고 소수점 아래를 버린다

// 샌드박스 1번
// 1. 일단 문자열을 다 대문자로 교체하는게 작업 할때 편할듯
// 2. 그리고 두글자씩 쪼개서 저장할 배열을 만듬
// 3. 맵구조로 저장해서 중복되는 애가 있으면 개수를 카운팅 하게
// 할거냐 아니면 하나하나 비교하며 개수를 세서 처리할거냐 생각해야할듯
// 여기에서 문자가 아닌 쌍은 버려야되니 예외처리 해줘야함
// 4. 그러고 교집합 / 합집합을 구한후 지정된 숫자를 곱해서 리턴
// 두개를 합치는 과정이 일단 필요

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class NewsClustering {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeMap(str1);
        Map<String, Integer> map2 = makeMap(str2);

        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        int inter = 0;
        int union = 0;

        for(String s : set){
            int count1 = map1.getOrDefault(s, 0);
            int count2 = map2.getOrDefault(s, 0);

            inter += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        if(union == 0){
            return 65536;
        }

        double jcard = ((double)inter / (double)union) * 65536;

        int answer = (int) jcard;
        return answer;
    }

    private Map<String, Integer> makeMap(String str) {
        HashMap<String, Integer> map = new HashMap<>();

        str = str.toLowerCase();
        for (int i = 0; i < str.length() -1 ; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);

            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String word = str.substring(i, i+2);
                map.put(word, map.getOrDefault(word, 0) +1);
            }
        }
        return map;
    }
}
