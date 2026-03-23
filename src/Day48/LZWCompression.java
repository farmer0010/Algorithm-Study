package Day48;

// 신입 사원 어피치는 카카오톡으로 전송되는 메시지
// 를 압축하여 전송 효울을 높이는 업무를 맡음
// 메시지가 압축되더라도 압축전의 정보가
// 완벽하게 복원가능한 무손실 압축 알고리즘 구현
// 알고리즘중 가장 효율이 좋은 lzw를 하기로 마음먹음

// lzw 압축 과정
// 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화
// 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열
// w를 찾는다 (w과 현재 입력 c가 다음 글자)
// 3. w에 해당하는 사전의 색인 번호를 출력하고
// w를 제거한다
// 4. 입력에서 처리되지않은 다음 글자가 남아있다면
// w+c에 해당하는 단어를 사전에 등록한다
// 5. 단계 2로 돌아간다

// 영어 대문자만 처리

// 샌드박스
// 무기선택: 맵구조? 아니면 노드로 클래스를 만들어서 처리
// 해야하나? 생각중
// 중복되지않은 새로운 단어일떄?

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LZWCompression {
    public int[] solution(String msg) {
        Map<String , Integer> dict = new HashMap<>();
        for(int i=0; i< 26; i++)
        {
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
        List<Integer> list = new ArrayList<>();
        int nextDictIdx = 27;
        for(int i=0; i<msg.length();)
        {
            int j = i+1;
            while(j <= msg.length() && dict.containsKey(String.valueOf(msg.substring(i, j))))
            {
                j++;
            }
            String w = msg.substring(i, j-1);
            list.add(dict.get(w));

            if(j <= msg.length())
            {
                String wc = msg.substring(i,j);
                dict.put(wc, nextDictIdx++);
            }
            i = j-1;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
