package Day161;

// 오픈채팅방

// 가상의 닉네임으로 접속 가능

// 채팅방에서 닉네임을 변경하는 방법 2가지
// 1. 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다
// 2. 채팅방에서 닉네임을 변경한다.

// 닉네임을 변경 할떄는 기존에 채팅방에 출력되어있던 닉네임도 전부 변경된다.
// 중복 닉네임 허용

// 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열이 주어질때
// 모든 기록이 처리된후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를
// 문자열 배열 형태로 리턴

// 일단 우리가 명백하게 구별할수있는 키는 uid를 통한 컬럼이다.
// 일단 맵을 통해 관리할것이고, uid와 닉네임을 통한 것을 만들거임
// 근데 핵심은 덮어 씌우는 거임

import java.util.*;

class OpenChatRoom {
    public String[] solution(String[] record) {
        HashMap<String, String> nick_map = new HashMap<>();

        for(int i = 0; i < record.length; i++){
            String[] cmd = record[i].split(" ");

            String status = cmd[0];

            if(status.equals("Enter") || status.equals("Change")){
                String id = cmd[1];
                String name = cmd[2];

                nick_map.put(id, name);
            }
        }

        ArrayList<String> lst = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            String[] cmd = record[i].split(" ");

            String status = cmd[0];
            String id = cmd[1];

            if(status.equals("Enter")){
                lst.add(nick_map.get(id) + "님이 들어왔습니다.");
            }
            else if(status.equals("Leave")){
                lst.add(nick_map.get(id) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[lst.size()];

        for(int i = 0; i < lst.size(); i++){
            answer[i] = lst.get(i);
        }

        return answer;
    }
}
