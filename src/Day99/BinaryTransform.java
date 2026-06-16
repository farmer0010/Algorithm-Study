package Day99;

// 0과 1로 이루어진 어떤 문자열 x에 대한 이진변한을 다음과 같이
// 정의한다
// x의 모든 0을 제거하려고하고
// x의 길이 c라고 하면 x를 "c를 2진법으로 표현한 문자열암"
// 0과 1로 이루어진 문자열 s가 매개변수로 주어지고
// s과 1일 될떄까지 계속해서 이진변환을 했을때
// 이진 변환하면서 변화된 횟차와, 제거된 모든 0 갯수를 각각 배열에 담아 리턴하시오

// 샌드박스
// 순서를 다시 상기 시켜보자
// 1. 0을 제거한다 (먼저 0의 개수를 세는 과정이 필요)
// 2. 0을 제거한 문자열의 길이를 세고 그걸 toBinaryString()으로
// 이진수로 변환한다.
// 3. 1,2 과정을 반복하면서 문자열의 길이가 1이면 종료되는 조건으로 마무리한다.


class BinaryTransform {
    public int[] solution(String s) {
        int change = 0;
        int zeroCount = 0;

        while(s.length() > 1){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeroCount++;
                }
            }
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            change++;
        }
        int[] answer = new int[2];
        answer[0] = change;
        answer[1] = zeroCount;
        return answer;
    }
}
