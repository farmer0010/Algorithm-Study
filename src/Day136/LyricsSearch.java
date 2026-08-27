package Day136;

// 가사 검색

// 노래가사에 사용된 단어들 중에 특정 키워드가 몇개 포함되어있는지 프로그램을 개발해야함
// 그 제안사항중 와일드 카드 문자인 '?'는 글자 하나를 의미하며 어떤 문자와도 매칭됨
// 글자수도 매칭 되고 문자도 매칭 되어야함

// 가사가 담긴 word 배열과 찾고자하는 키워드가 담긴 배열 queries가 주어질 때
// 각 키워드 별로 매치된 단어가 몇개인지 순서대로 배열에 담아 반환

// 가사 단어 제한 상황
// 가사에 동일 단어가 여러번 나욜 경우 중복을 제거하고 words에는 하나로만 제공됨
// 각 가사 단어는 오직 알파벳 소문자로만 구성됨

// 검색 키워드 제한사항
// 검색키워드는 중복될수도 있고 각 검색 키워드는 오직 알파벳 소문자와 와일드 카드 문자인 '?'로만 구성되며 특수문자나
// 숫자는 포함되지않음, 와일드 카드 문자인 '?'가 하나 이상 포함돼있으며, ? 는 각 검색의 키워드 접두사 아니면 접미사중
// 하나로만 주어짐

// 샌드 박스
// 1. words 배열을 돌면서 트라이구조를 만들어주면 되는데 없는 단어이면 만들어주고 공통된 부분이 있으면 그걸 타고 가고,
// 그 부분을 넘기면 새로 만들며 추가해주는 구조로 가야될것 같음
// 2. 노드를 만들때 어떠한 클래스로 만들어줘야하나? 예를 들어서 frodo에서 f를 타고있고 얘를 맵형태로 타고가면
// Node에는 어떤게 만들어야할지 생각해봐야함
// 3. 접두사에 영어로 나오면 찾기 괜찮은데 와일드 카드로 등장하는 경우엔 와일드 카드 갯수를 체크하고
// 그만큼의 길이를 건너 띄면 몇개인지 세는게 좋을 것같은 느낌?

import java.util.*;

class Solution {
    class Node {
        Map<Character, Node> children = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Node root = new Node();
        Node reverseRoot = new Node();

        for(String word : words){
            insert(root, word);

            String rWord = reverse(word);

            insert(reverseRoot, rWord);
        }

        for(int i = 0; i < queries.length; i++){
            String word = queries[i];

            if(word.charAt(0) == '?'){
                String rWord = reverse(word);
                int n = search(reverseRoot, rWord);
                answer[i] = n;
            }
            else{
                int k = search(root, word);
                answer[i] = k;
            }
        }

        return answer;
    }

    private String reverse(String word){
        StringBuilder sb = new StringBuilder();

        for(int i = word.length() -1; i >=0; i--){
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }

    private void insert(Node root, String word){
        Node cur = root;

        cur.count.put(word.length(), cur.count.getOrDefault(word.length(), 0) + 1);

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            cur = cur.children.computeIfAbsent(c, k -> (new Node()));
            cur.count.put(word.length(), cur.count.getOrDefault(word.length(), 0) + 1);
        }
    }

    private int search(Node root ,String query){
        Node cur = root;
        int index = query.indexOf('?');

        for(int i = 0; i < index; i++){
            char c = query.charAt(i);

            if(cur.children.get(c) == null){
                return 0;
            }
            else{
                cur = cur.children.get(c);
            }
        }
        return cur.count.getOrDefault(query.length(), 0);


    }
}
