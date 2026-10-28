package Day158;

// 대충 만든 자판

// 동일한 키를 연속해서 빠르게 누르면 할당된 순서대로 문자가 바뀜
// ex) a,b,c 순서대로 문자가 할당 되어있으면 1번 키를 누르면 a, 2번 누르면 b, 3번 누르면 c
// 같은 규칙을 적용해 만든 자판이 있음

// 키맵을 통해서 그 횟수로 이동할 수 있는 최소 횟수를 맵에다가 넣어야하는데
// 이 최소횟수를 어떻게 파악하고 집어 넣을지가 관건임
// 이 맵에 키가 없다면 그 순서에 해당하는 애를 넣어주는게 관건일 것같은데
// 왜냐하면 먼저 들어가는 애가 순서에 관건이니깐

import java.util.HashMap;

class RoughKeypad {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < keymap.length; i++){
            String s = keymap[i];

            for(int k = 0; k < s.length(); k++){
                char ch = s.charAt(k);

                if(! map.containsKey(ch)){
                    map.put(ch, k + 1);
                }
                else{
                    int n_k = map.get(ch) + 1;
                    if(k + 1 < n_k){
                        map.put(ch, k+1);
                    }
                }
            }
        }

        for(int i = 0; i < targets.length; i++){
            String str = targets[i];
            int count  = 0;
            boolean flag = true;

            for(int k = 0; k < str.length(); k++){
                char ch = str.charAt(k);

                if(map.containsKey(ch) && flag){
                    count += map.get(ch);
                }
                else{
                    answer[i] = -1;
                    flag = false;
                    break;
                }

                answer[i] = count;
            }
        }
        return answer;
    }
}
