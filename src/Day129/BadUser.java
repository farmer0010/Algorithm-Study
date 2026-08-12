package Day129;

// 불량 사용자

// 비정상적인 응모자들을 따로 모아 불량 사용자라는 이름으로
// 목록을 만들어서 당첨 처리시 제외 하도록 전달
// 개인 정보를 위해 일부문자를 * 문자로 가려서 전달함
// 가리고자 하는 문자 하나에 * 문자 하나를 사용했고 아이디당 최소 하나
// 이상의 * 문자를 사용함

// 이벤트 응모자 아이디 목록이 담긴 user_id 배열과
// 불량 사용자 아이디 목록이 담긴 banned_id 매개변수가 주어질 때
// 당첨에서 제외되어야 할 제제 아이디 목록은 몇가지 경우의 수가 나오는지
// 리턴

// 샌드 박스
// 1. 일단 배열의 크기가 작기 떄문에 bfs나 dfs, for문으로 다 도전해볼만 한 사이즈임
// 생각이 든게 dfs로 풀어본다고 하면 문자열 길이가 같은지 비교하는 함수와
// * 표에 대해서 고민을 해봐야할 것같은 그리고 벤 id와 유저 id를 비교하는데 *을 제외한 갯수와
// 뺀 이름의 위치와 갯수과 같다면 같은 거니깐

// 순서만 다른거 같은 조합이 나중에 set에다가 넣고 set.size 반환하면 될것같긴하다

import java.util.*;

class BadUser {
    int answer = 0;
    Set<Set<Integer>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {

        boolean visit[] = new boolean[user_id.length];
        dfs_ban(user_id, banned_id, 0, visit);

        return result.size();
    }

    private void dfs_ban(String[] user_id, String[] banned_id, int index, boolean[] visit){
        Set<Integer> set = new HashSet<>();

        if(index == banned_id.length){
            for(int i = 0; i < visit.length; i++){
                if(visit[i])
                    set.add(i);
            }
            result.add(set);
            return;
        }

        for(int i = 0; i < user_id.length; i++){
            if(logic(banned_id[index], user_id[i]) && !visit[i] ){
                visit[i] = true;
                dfs_ban(user_id, banned_id, index + 1, visit);
                visit[i] = false;
            }
        }
    }

    private boolean logic(String target, String pract){
        int cnt = 0;
        int diff = 0;

        if(target.length () != pract.length())
            return false;

        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) == '*')
                cnt++;
        }
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != pract.charAt(i)){
                diff++;
            }
        }

        return diff == cnt ? true : false;
    }
}
