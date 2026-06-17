package Day100;

// JadenCase는 모든 단어의 첫 문자가 대문자이고
// 그 외에 알파벳은 소문자인 문자열임
// 단 첫문자가 알파벳이 아닐때는 알파벳을 소문자로 쓰면 된다
// 문자열 s가 주어졌을 때 s를 저 제이든 케이스로 바꾼 문자열을
// 리턴

// 예외 상황 : 공백 여러개 등장 가능


class JadenCase {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(" ");
                isFirst = true;
            }
            else{
                if(isFirst){
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                }
                else{
                    sb.append(Character.toLowerCase(c));
                }
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
