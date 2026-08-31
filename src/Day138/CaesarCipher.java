package Day138;

// 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서

// 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고함
// 문자열 s에서 거리를 n을 입력 받아 s를 n만큼 민 암호화를 만드는 함수를 구하시오

// 문자는 알파벳과 공백만 들어옴
// 그래서 알파벳인지 검사를 하고 아니라면 그냥 출력되게 넣어주면 되는데
// 그만큼 넘어간 문자일 경우 다시 맨앞으로 돌아옴

class CaesarCipher {
    public String solution(String s, int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLetter(ch)){
                if(Character.isUpperCase(ch)){
                    char ch_n = (char)(ch + n);
                    if(ch_n > 'Z'){
                        int k = ch_n - 'Z' -1;
                        char ch_n_k = (char) ('A' + k);
                        sb.append(ch_n_k);
                    }
                    else{
                        sb.append(ch_n);
                    }
                }
                if(Character.isLowerCase(ch)){
                    char ch_n = (char)(ch + n);
                    if(ch_n > 'z'){
                        int k = ch_n - 'z' - 1;
                        char ch_n_k = (char) ('a' + k);
                        sb.append(ch_n_k);
                    }
                    else{
                        sb.append(ch_n);
                    }
                }
            }
            else{
                sb.append(ch);
            }
        }
        answer = sb.toString();

        return answer;
    }
}
