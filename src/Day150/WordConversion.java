package Day150;

// 단어 변환

// begin에서 target으로 변환하는 가장 짧은 과정을 찾으려고함

// 변환 조건
// 1. 한번에 한개의 알파벳만 변경 가능
// 2. words에 있는 단어로만 변환가능

// 이것은 dfs로도 가능하고, bfs로도 가능함 (주어지는 길이를 보면)
// 하지만 글자의 위치를 기록할 인덱스는 필요하다고 생각함

import java.util.*;

class WordConversion {
    class Node{
        String word;
        int num;

        public Node(String word, int num){
            this.word = word;
            this.num = num;
        }
    }

    boolean visit[];

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        visit = new boolean[words.length];

        answer = bfs(begin, target, words);

        return answer;
    }
    public int bfs(String begin, String target, String[] words){
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(begin, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            String w = cur.word;
            int count = cur.num;

            if(w.equals(target)){
                return count;
            }

            for(int i = 0; i < words.length; i++){
                if(!visit[i] && one_word(w, words[i])){
                    q.offer(new Node(words[i], count + 1));
                    visit[i] = true;
                }
            }
        }
        return 0;
    }

    public boolean one_word(String str, String str2){
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str2.charAt(i))
                count++;
        }
        if(count == 1)
            return true;
        return false;
    }
}