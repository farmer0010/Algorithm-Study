package Day146;

// 선수들이 자기 바로 앞의 선수를 추월 할 때 추월한 선수의 이름을 부름

// 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 playes와 해설진이 부른 이름
// 을 담은 문자열 배열 calling가 매개변수로 주어질 때 경주가 끝났을때 선수들의 이름을 1등부터
// 등 순서대로 배열에 담아 리턴

// 샌드박스
// 일단 저 배열을 어떤식으로 옮길지 자료구조를 생각해봐야 할것같은데
// 현재 인덱스의 위치를 뭐 기억 할 필요는 없긴할 것같은데 어떻게 이동 시킬지 고민해보면 좋을듯함

import java.util.*;

class RunningRace {

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<Integer, String> map_call = new TreeMap<>();

        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
            map_call.put(i, players[i]);
        }

        for(int i = 0; i < callings.length; i++){
            if(map.containsKey(callings[i])){
                int cur = map.get(callings[i]);
                String frot_player = map_call.get(cur - 1);

                map.put(callings[i], cur -1);
                map.put(frot_player, cur);
                map_call.put(cur-1, callings[i]);
                map_call.put(cur, frot_player);
            }
        }
        String[] answer = new String[map_call.size()];

        int index = 0;
        for(String value : map_call.values()){
            answer[index++] = value;
        }


        return answer;
    }
}
