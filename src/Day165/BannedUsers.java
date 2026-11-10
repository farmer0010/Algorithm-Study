package Day165;

// 불량 사용자

// 이벤트 당첨자중 불량 사용자 이름을 목록으로 만들어 제외
// 이 떄 개인 정보 보호를 위해, 사용자 아이디중 일부 문자를 *로 가림
// 당첨자에서 제외되어야할 제제 아이디 목록이 몇개인지를 리턴

// 배열의 크기가 크지않아 단순 구현으로
// 근데 제제 아이디 목록을 구했을 때 아이디 내용이 같다면 동일한 것으로 보아
// 하나로 세면 됨 이건 hashset으로 처리
// ban, user를 비교했을 때 *의 개수와 다른것의 개수가 동일하게 나와야함

import java.util.*;

class BannedUsers {
    HashSet<HashSet<String>> result = new HashSet<>();
    ArrayList<ArrayList<String>> candidates = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        for (String ban : banned_id) {
            ArrayList<String> list = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(ban, user)) {
                    list.add(user);
                }
            }
            candidates.add(list);
        }

        dfs(0, new HashSet<>(), banned_id.length);

        return result.size();
    }

    private void dfs(int idx, HashSet<String> picked, int bannedCount) {
        if (idx == bannedCount) {
            result.add(new HashSet<>(picked));
            return;
        }

        for (String user : candidates.get(idx)) {
            if (picked.contains(user)) continue;

            picked.add(user);
            dfs(idx + 1, picked, bannedCount);
            picked.remove(user);
        }
    }

    private boolean isMatch(String ban, String user) {
        if (ban.length() != user.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (ban.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}
