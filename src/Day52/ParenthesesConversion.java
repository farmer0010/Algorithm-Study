package Day52;

// 괄호 변환
// 소스 코드 오류 파일 검출
// 문제점: 작성된 괄호 갯수는 맞지만
// 짝이 맞지않는 형태로 작성됨
// 소스코드에 모든 괄호를 뽑아서 올바른 순서로 배치

// 1. () 로만 이루어진 문자열이 있을 경우
// (,)의 개수가 같다면 균형 잡힌 괄호 문자열이라고 부름
// (,) 위에 경우에 괄호의 짝도 맞을 경우
// 올바른 괄호 문자열이라고 함

//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u,
//        v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//  4-3. ')'를 다시 붙입니다.
//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.

// 샌드박스 : 올바른 괄호 문자열인 경우와 그렇지않은 경우를 생각
// u,v를 분리하는 기준이 뭐지?
// 균형잡힌 괄호 문자열로만 분리 (개수 확인만 되면 됨)

class ParenthesesConversion {
    public String solution(String p) {
        String answer = "";
        String u = "";
        String v = "";
        if(p.length() == 0)
            return answer;
        int leftCnt = 0, rightCnt = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                leftCnt++;
            else
                rightCnt++;
            if(leftCnt == rightCnt)
            {
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                break;
            }
        }
        if(isCorrect(u))
            return u + solution(v);
        else
        {
            String temp = "";
            temp += "(";
            temp += solution(v);
            temp += ")";
            for(int i = 1; i < u.length() -1; i++) {
                if(u.charAt(i) == '(')
                    temp += ")";
                else
                    temp += "(";
            }
            return temp;
        }
    }
    private boolean isCorrect(String u)
    {
        boolean answer = true;
        int openCnt = 0;

        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(')
                openCnt++;
            else
                openCnt--;

            if(openCnt < 0)
                answer = false;
        }

        return answer;
    }
}