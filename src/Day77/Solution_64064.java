package Day77;

// 무지는 최근 진행된 카카오 이모티콘 이벤트에
// 비정상적인 방법으로 당첨을 시도한 응모자들을 발견

// 이런 응모자들을 따로 모아 불량 사용자라는 이름으로 목록을
// 만들어 당첨 처리시 제외하도록 프로도에게 전달하려고 한다
// 이 때 개인정보 보호를 위해 사용자 아이디중 일부 문자를
// *로 가려서 전달했음

// 불량 사용자 목록에 매핑된 응모자 아이디를 제재 아이디라고 칭함
// user_id: 이벤트 응모자
// banned_id : 불량 사용자 아이디 목록이 담긴 배열

// 당첨에서 제어되어야할 제재 아이디 목록은 몇가지 경우의 수인지?

// 제한사항: 응모한 사용자 아이디들은 서로 중복되지 x
// -> 해시인가 생각하다가 애초에 중복되지않는데 해시를 써야하나?
// 불량 사용자 아이디는 * 모양 하나 이상 포함되어야하고
// 불량 사용자 아이디 하나는 응모자 아이디중 하나에 해당하고
// 같은 응모자 아이디가 중복해서 제재 아이디 목록에 들어가는 경우는 x
// 제재 아이디 목록들을 구했을 때 아이디의 나열된 순서와 관계
// 없이 목록의 내용이 동일 하다면 같은 것으로 처리하여 하나로 세면됨
// -> 이게 해시이고 모든 경우의 수를 따져야되는데
// 수가 크지않으니 dfs로 돌려야하는데 어떻게 돌릴지 생각좀 해보자

// 벤 id의 *찍힌 인덱스를 파악해야되나?
// 그리고 user id와 banned id를 비교해서 하는 방식?
// 감이 안오네

import java.util.HashSet;

class Solution_64064 {
    HashSet<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        for(int i = 0; i < banned_id.length; i++){
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        boolean[] visited = new boolean[user_id.length];
        dfs_ban(0,visited, user_id, banned_id);

        return set.size();
    }

    private void dfs_ban(int depth, boolean[] visited, String[] userId, String[] bannedId) {

        if(depth == bannedId.length){
            String temp = "";

            for (int i = 0; i < userId.length; i++) {
                if(!visited[i]){
                    temp += userId[i] + " ";
                }
            }
            set.add(temp);
            return;
        }
        for (int i = 0; i < userId.length; i++) {
            if(!visited[i] && userId[i].matches(bannedId[depth])){
                visited[i] = true;
                dfs_ban(depth+1, visited, userId, bannedId);
                visited[i] = false;
            }
        }
    }
}
