package Day35;

// 기사의 제목 기준으로 주목 기사가 나뉘는걸 발견
// 유사한 기준을 묶는 기준을 정하기 위해 자카드 유사도?
// 자카드 유사도: 집한간 유사도 검증?
// 두 집합 A,B 사이의 자카드 유사도는 J(A,B)
// 자카드 유사도 : (두 집합 교집합 크기) / (두 집합 합집합 크기)
// 공집합일 경우 자카드 유사도는 1로 정의
// 자카드 유사도는 원소의 중복을 허용하는 다중집합 (리스트?)
//  MAX와 MIN 활용이 필요할지도?
// 두글자씩 끊어서 다중 집합 원소
// AB+ 같이 특수문자있는 경우 AB는 챙기고 B+는 버린다
// 65536 이거를 나온 유사도에 곱해줘야함
// 페이스 메이커가 준 힌트: 어떻게 문장을 두글자씩 쪼개고 특수문자는 버리는가?
// 다중 집합의 경우 갯수를 세야함 처음엔 리스트라고 생각했지만
// 갯수를 생각하면 MAP이 맞을듯?
// 교집합과 합집합 -> 교집합은 s1.equals == s2.equals로 하면 될것같은데
// 합집합은 잘 감이 안잡힘

import java.util.ArrayList;
import java.util.List;

class NewsClustering {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        // 정규식은 본기억이 없음
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for (int i = 0; i < str1.length() -1; i++) {
            String sub = str1.substring(i, i + 2);
            if(sub.matches("^[A-Z]*$"))
            {
                list1.add(sub);
            }
        }
        for (int i = 0; i < str2.length()-1; i++) {
            String sub = str2.substring(i, i + 2);
            if(sub.matches("^[A-Z]*$"))
            {
                list2.add(sub);
            }
        }
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        for (String s : list1) {
            if(list2.contains(s))
            {
                intersection.add(s);
                list2.remove(s);
            }
        }
        double unionSize = list2.size() + list1.size();
        double jacard = ((double) intersection.size() / unionSize) * 65536;

        int answer = (int)jacard;
        return answer;
    }
}
