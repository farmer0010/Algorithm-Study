package Day104;

// 오픈 채팅방
// 카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할
// 수 있는데 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방
// 에 들어갈 수있다

// 근데 카카오톡 오픈 채팅 개설한 사람을 위해 다양한 사람들이
// 들어오고, 나가는 것을 지켜볼 수있는 관리자 창을 생성하려고함

// 입장시 [닉네임] 입장, 퇴장시 [닉네임 퇴장]
// 채팅방에서 닉네임이 변경하는 방법은 두가지임
// 1. 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다
// 2. 채팅방에서 닉네임을 변경한다.

// 닉네임을 변경 할때에는 기존의 채팅방에 출력되어있던 메시지의
// 닉네임도 전부 변경된다
// 채팅방은 중복 닉네임을 허용
// 채팅방에 들어오고 나가거나 닉네임을 변경함 기록이 담긴 배열이 주어짐
// 모든 기록이 처리된 후 최종적으로 방을 개설한 사람이 보게되는 메시지를
// 문자열 배열 형태로 리턴

// 모든 유저는 유저id로 구별,
// 입장은 enter, 퇴장은 leave, 닉네임 변경은 change
// 각 단어는 공백으로 구별되고, 대소문자 구별되어야함

// 샌드박스
// 주의 : 맵은 중복 허용이 안되니 새로운 데이터가 들어오면 갱신됨
// 1. 일단 처음으로 생각이 든건 맵구조를 통해서 uid와 닉네임을
// 관리해서 저장시켜야한다.
// 2. 파싱을 통해 저 명령어를 구별 시키며 맵 구조에 넣어야되고
// 3. 최종적으로 저 명령을 통해 출력문을 업데이트 시켜야한다

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OpenChat {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();

        for(String s : record){
            String[] arr = s.split(" ");
            String cmd = arr[0];
            String uid = arr[1];

            if(cmd.equals("Enter") || cmd.equals("Change")){
                String nick = arr[2];
                userMap.put(uid, nick);
            }
            else
                continue;
        }

        List<String> list = new ArrayList<>();
        for (String s : record) {
            String[] arr = s.split(" ");
            String cmd = arr[0];
            String uid = arr[1];
            if(cmd.equals("Enter")){
                list.add(userMap.get(uid) + "님이 들어왔습니다.");
            }
            else if(cmd.equals("Leave")){
                list.add(userMap.get(uid) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[0]); // 배열의 크기를 신경 쓰기보다 배열의 타입을 명시해준다고 생각하면 편함
    }
}
