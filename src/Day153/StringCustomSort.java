package Day153;

import java.util.Arrays;

class StringCustomSort {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (a, b) -> {
            if(a.charAt(n) == b.charAt(n)){
                return a.compareTo(b);
            }
            return a.charAt(n) - b.charAt(n);
        });

        String[] answer = new String[strings.length];

        int index = 0;
        for(String str : strings){
            answer[index++] = str;
        }
        return answer;
    }
}
