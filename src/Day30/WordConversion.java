package Day30;

import java.util.LinkedList;
import java.util.Queue;

class WordConversion {
    static class Node {
        String name;
        int idx;
        Node(String name, int idx) {
            this.name = name;
            this.idx = idx;
        }
    }

    boolean canChange(String s1, String s2)
    {
        int diff = 0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
                diff++;
            if(diff > 1)
                return false;
        }
        return diff==1;
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Node(begin,0));
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.name.equals(target))
                return current.idx;
            for (int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                if(canChange(current.name, words[i]))
                {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.idx + 1));
                }
            }
        }
        return 0;
    }
}
