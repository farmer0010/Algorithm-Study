package Day4;

import java.util.HashMap;

class PersonalityTest {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] split = {{'R','T'},{'C', 'F'},{'J', 'M'}, {'A', 'N'}};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < survey.length; i++) {
            if(choices[i] == 1){
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + 3);
            }
            else if(choices[i] == 2){
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) +2);
            }
            else if(choices[i] == 3){
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) +1);
            }
            else if(choices[i] == 5){
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0)+1);
            }
            else if(choices[i] == 6){
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + 2);
            }
            else if(choices[i] == 7){
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + 3);
            }
            else
                continue;
        }
        for (int i = 0; i < split.length; i++) {
            char first = split[i][0];
            char second = split[i][1];
            Integer i1 = map.getOrDefault(first, 0);
            Integer i2 = map.getOrDefault(second, 0);
            if(i1 >= i2)
                answer += first;
            else
                answer += second;
            }
        return answer;
    }
}
