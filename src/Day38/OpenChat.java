package Day38;

// 오픈채팅방
// 1. 오픈채팅방은 본래 닉네임이 아닌 가상 닉네임으로 접속
// 2. 채팅방에 닉네임을 변경하는 방법 2가지
// 2_1 . 채팅방을 나간 후 새로운 닉네임으로 다시 들어옴
// 2_2 . 채팅방에서 닉네임을 변경
// 3. 닉네임을 변경할떄는 기존에 채팅방에 있던
// 메시지 닉네임도 전부 변경
// Enter은 접속, Leave는 퇴장, change는 닉네임 변경

// 샌드박스
// 1. 일단 record 문자열을 spilt으로 공백을 구분하여
// 쪼개야할 것같음
// 2. 특정 id의 마지막 닉네임을 저장 그러면 맵구조?
// 이지않을까 싶긴함 (맵에다가는 유저 id가 k , 닉네임 v)
// 3. 닉네임이 변경된 경우 최신 닉네임으로 톡방을 싹 엎데이트하고
// 메시지 생성
// 4. enter와 leave는 메시지를 출력하지만 change는 출력x
// if문으로? 찾아야되지않을까싶긴한데 잘모르겠음

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OpenChat {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String s : record) {
            String[] words = s.split(" ");
            if(words[0].equals("Enter") || words[0].equals("Change")){
                map.put(words[1], words[2]);
            }
        }
        for (String s : record) {
            String[] words = s.split(" ");
            if(words[0].equals("Enter")){
                list.add(map.get(words[1])+ "님이 들어왔습니다.");
            }
            else if(words[0].equals("Leave")){
                list.add(map.get(words[1])+ "님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
