package Day140;

// 문자열 길이가 4혹은 6이고 숫자로만 구성돼있는지 확인해주는 함수를
// 완성해라

class StringHandlingBasic {
    public boolean solution(String s) {
        boolean answer = false;

        if(s.length() == 4 || s.length() == 6){
            for(int i = 0; i < s.length(); i++){
                if(Character.isDigit(s.charAt(i))){
                    answer = true;
                }
                else{
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
