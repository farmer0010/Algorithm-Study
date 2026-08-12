package Day129;

// 단어 변환

// 두개의 단어 begin, target과 단어의 집합 words가 있다 아래와 같은 규칙을
// 활용하여 begin에서 target으로 변환하는 가장 짧은 과정을 찾으려고 함

// 규칙 1. 한번에 한개의 알파벳만 변환 가능
// 규칙 2. words에 있는 단어로만 변환 할수 있다

// 각 단어는 소문자로만 이루어짐

// 샌드 박스
// 1. 변환 되는 동안의 최소 과정의 수를 잡아야하니 bfs, dfs 둘 중 하나로 생각하면 될듯
// 숫자의 크기도 크지않을걸 보니
// 2. bfs로 풀어본건데 어떤식으로 활용하냐 알파벳이 하나만 다른애들을 체크를 해야함
// 모든 식의 경우의 수를 내리면 규칙에 어긋 나니깐

import java.util.*;

class WordTransformation {
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }

    private int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();

            String cur = current.word;
            int depth = current.depth;

            if (cur.equals(target)) {
                return depth;
            }

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                if (!visited[i] && isOne(cur, word)) {
                    visited[i] = true;
                    q.offer(new Node(word, depth + 1));
                }
            }
        }

        return 0;
    }

    private boolean isOne(String str1, String str2) {
        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    static class Node {
        String word;
        int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
