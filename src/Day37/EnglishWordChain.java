package Day37;

// 1. n명의 사람이 돌아가면서 끝말잇기를 함
// 2. 탈락 조건
// 2_1. 앞 사람이 말한 단어의 마지막 글자와 내 단어의 첫 글자가 다를떄
// 2_2. 중복된 단어가 또 등장을 했을때
// 반환값은 번호, 차례 (탈락자가 없으면 0,0을 반환)

// 샌드박스
// 1. 이 단어가 아까 나왔는지 확인하기 위해서는 set?
// 2. 유효성 체크
// 2-1 . 앞단어의 끝 인덱스와 이번단어 첫 인덱스 비교방법?은 감이 잘 안옴
// set에는 중복이 들어갈수없기때문에 들어가지않았다면?
// 3-1 이 사람이 몇번 사람인지는 나머지 연산
// 3-2 이 사람이 몇번째 차례인지는 몫으로 연산

import java.util.HashSet;

class EnglishWordChain {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            if (prev.charAt(prev.length() - 1) != curr.charAt(0) || set.contains(curr)){
            return new int[]{(i%n)+1, (i/n)+1};
            }
            set.add(curr);
        }
        return new int[]{0, 0};
    }
}
