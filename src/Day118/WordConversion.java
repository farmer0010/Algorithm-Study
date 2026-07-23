package Day118;

// 단어 변환

// 두개의 단어 begin과 target과 같은 단어의 집합이 있음

// 아래의 규칙을 가지고 단어를 변환하는 가장 짧은 변환 과정을
// 거치려고한다.

// 규칙
// 1. 한번에 한개의 알파멧만 바꿀 수 있음
// 2. words에 있는 단어로만 변경 가능함

// 두개의 단어 begin과 target이 주어졌을 때 최소
// 몇단계의 과정을 거쳐 begin을 target으로 변환할수있는지를
// 리턴해라

// 각 단어의 길이는 3이상 10이하이고 길이는 같음
// 중복된 단어 X
// 반환이 불가능한 경우에는 0을 리턴

// 샌드박스
// 모든 경우의 수를 세고 터지지않는정도의 짧기 떄문에
// dfs나 bfs로 최적의 수를 구하면 될것같음

// 1. 생각이 든거 자리수에 뭔가 있는지 체크해야됨
// 일단 지금 느낀건 인덱스의 위치에 단어 비교가 핵심
// 2. 첫번째 인덱스 글자부터 마지막 인덱스 글자까지 돌고
// 다시 패싱 근데 이 조건에서 같은 단어가 있지만 한개만 변경하는지
// 체크 두개 이상 변경된다 보이면 바로 패싱
// 3. 종료조건은 begin과 target이 같을 때겟지

import java.util.*;

class WordConversion {
    class WordNode{
        String word;
        int count;

        WordNode(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    static boolean[] isCheck;
    int answer = 0;

    public int solution(String begin, String target, String[] words) {

        isCheck = new boolean[words.length];

        answer = bfs_word(begin,target, words,0);


        return answer;
    }

    private int bfs_word(String begin, String target, String[] words, int cnt) {
        Queue<WordNode> q = new LinkedList<>();
        q.offer(new WordNode(begin, cnt));

        while(!q.isEmpty()){
            WordNode node = q.poll();
            String word = node.word;
            int count = node.count;

            if(word.equals(target)){
                return count;
            }
            for(int i = 0; i < words.length; i++){
                if(! isCheck[i] && canConvert(word, words[i])){
                    isCheck[i] = true;
                    q.offer(new WordNode(words[i], count+1));
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String word1, String word2) {
        int ans = 0;

        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                ans++;
            }
        }
        return ans == 1;
    }
}
