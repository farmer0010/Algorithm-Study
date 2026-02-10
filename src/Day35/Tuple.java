package Day35;

// 셀수 있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 모음: 튜플
// 튜플은 중복된 원소가 있을수 있다 (해시 x)
// 원소는 정해진 순서가 있으며 원소의 순서가 다르면 서로 다른 튜플
// 정해진 순서 ? 리스트로 정렬이 필요한가?
// 원소 갯수 n에 중복되는 원소가 없는 튜플이 주어진다는것은 해시?
// s가 주는 튜플을 해시에 넣은 다음 배열에 담아 어떻게 리턴할지
// spilt으로 쪼개는 과정과 저 문자열의 숫자인 문자를 숫자로 변환하는 과정
// 이 필요하지않을까?
// 페이스메이커가 준 힌트중에서 어떻게 저 중괄호를 떼고 뭔가 문자열 함수
// 중에 그런게 있지않을까?? 순서는 하나인 배열, 2개인 배열, 3개인 배열
// 4개인 배열씩 순서로 나열되는데 그게 핵심 포인트?
// 저장은 hash에 하면 될것같은데?

import java.util.Arrays;
import java.util.HashSet;

class Tuple {
    public int[] solution(String s) {
        // 문자열 껍질 벗기기
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] words = s.split("-");
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[words.length];
        int idx = 0;

        for (String word : words) {
            String[] parts = word.split(",");
            for (String part : parts) {
                if (!set.contains(part)) {
                    set.add(part);
                    answer[idx++] = Integer.parseInt(part);
                }
            }
        }
        return answer;
    }
}
