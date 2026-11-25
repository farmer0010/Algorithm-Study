package Day172;

// 샌드박스

// 두개의 단어 begin, target과 단어의 집합 words가 있음
// begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 함

// 1. 한번에 한개의 알파벳만 변경 가능
// 2. words에 있는 단어로만 변환할 수 있음

// 최단 경로를 찾는것 이기떄문에 bfs를 활용해야할 것같은데 , 경우의 수가 많지 않기에 dfs도 가능하긴함
// bfs 활용함수와, 문자가 하나만 다른건지 판별하는 함수가 필요할 것 같음

import java.util.*;

class WordConversion {
    List<Integer> lst = new ArrayList<>();
    boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;

        visit = new boolean[words.length];

        List<String> list = new ArrayList<>();

        for(String word : words){
            list.add(word);
        }

        if(!list.contains(target)){
            return 0;
        }

        dfs(begin, target, 0, words);

        for(int n : lst){
            answer = Math.min(answer, n);
        }

        return answer;
    }

    public void dfs(String begin, String target, int count, String[] words){

        if(begin.equals(target)){
            lst.add(count);
            return;
        }


        for(int i = 0; i < words.length; i++){
            if(one_diff(begin, words[i])){
                if(!visit[i]){
                    visit[i] = true;
                    dfs(words[i], target, count + 1, words);
                    visit[i] = false;
                }
            }
        }
    }

    public boolean one_diff(String str1, String str2){
        int count  = 0;

        for(int i = 0; i < str1.length(); i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(ch1 != ch2){
                count ++;
            }
        }

        if(count == 1)
            return true;
        else
            return false;
    }
}
