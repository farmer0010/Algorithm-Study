package Day41;

// 알파벳 모음으로 시작하는 길이 5이하 단어를 정의한
// 사전 만들기
// 매개변수인 단어가 사전에서 주어질 때 몇번째 단어인지 찾
// 는 문제

import java.util.ArrayList;
import java.util.List;


class VowelDictionary {
    List<String> list = new ArrayList<String>();
    String[] vowels = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1;
    }

    private void dfs(String str, int len) {
        if(!str.equals("")) {
            list.add(str);
        }
        if(len == 5)
            return;
        for(int i = 0; i < vowels.length; i++) {
            dfs(str + vowels[i], len + 1);
        }
    }
}
