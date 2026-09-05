package Day140;

// 이상한 문자 만들기

// 문자열 s는 한개 이상의 단어로 구성됨 각 단어는 하나 이상의 공백 문자로 구별됨
// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번쨰 알파벳은 소문자로 바꾼 문자열을 리턴하시오

class StrangeCharacter {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        String[] words = s.split(" ", -1);

        for(int i = 0; i < words.length; i++){
            String word = words[i];

            for(int k = 0; k < word.length(); k++){
                char c = word.charAt(k);

                if(k%2 == 0){
                    c = Character.toUpperCase(c);
                    sb.append(c);
                }
                else{
                    c = Character.toLowerCase(c);
                    sb.append(c);
                }
            }
            if(i < words.length -1){
                sb.append(" ");
            }
        }
        answer = sb.toString();

        return answer;
    }
}
