package Day109;

// 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 정의함

// 1. x의 모든 0은 제거한다
// 2, x의 길이를 c라고 하면 x를 "c"를 2진법으로 표현한 문자열로
// 바꿈
// 0과 1로 이루어진 문자열 s가 매개변수가 주어지고 s가 1일 될때까지
// 이것을 반복하여 이진 변환 회수와 변화과정에서 제거된 모든 0의 개수를
// 리턴

// 샌드박스
// toBinaryString 함수를 통해서 이진 변환을 거칠꺼임
// 중간중간 0을 지워주는 가정도 필요할듯

class RepeatBinary {
    public int[] solution(String s) {
        int bin = 0;
        int zeroCount = 0;

        while(!s.equals("1")){
            int num = s.length();
            for(int i = 0; i < num; i++){
                if(s.charAt(i) == '0'){
                    zeroCount++;
                }
            }
            s = s.replace("0","");
            s = Integer.toBinaryString(s.length());
            bin ++;
        }

        int[] answer = new int[2];
        answer[0] = bin;
        answer[1] = zeroCount;
        return answer;
    }
}
