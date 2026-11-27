package Day174;

import java.util.*;

class WordConversion {
    class Node{
        String s;
        int count;

        public Node(String s, int count){
            this.s = s;
            this.count = count;
        }
    }

    boolean[] visited;
    int answer = 0;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        bfs(begin, target, words);

        return answer;
    }

    public void bfs(String begin, String target, String[] words){
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(begin, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            String curS = cur.s;
            int cnt = cur.count;

            if(curS.equals(target)){
                answer = cnt;
                return ;
            }

            for(int i = 0; i < words.length; i++){
                if(!visited[i] && diff_word(curS, words[i])){
                    q.offer(new Node(words[i], cnt+1));
                    visited[i] = true;
                }
            }
        }
    }

    boolean diff_word(String str1, String str2){
        int count = 0;

        for(int i = 0; i < str1.length(); i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if(ch1 != ch2){
                count++;
            }
        }
        if(count == 1)
            return true;
        else
            return false;
    }
}
