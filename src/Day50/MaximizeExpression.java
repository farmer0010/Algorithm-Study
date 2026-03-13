package Day50;

// 수식 최대화
// 라이언이 해커톤을 개최함
// 참가하는 모든 참가자들에게 +,-,* 연산 문자로만
// 이루어진 연산 수식이 전달됨
// 참가자 미션: 연산자의 우선순위를 자유롭게 재정의 하여
// 만들수 있는 가장 큰 수를 제출
// 2개 이상의 연산자 순위는 연산자 우선순위에 정의 될수 없음

//만약에 계산된 결과과 음수라면 해당 숫자를 절대값으로 변환하여
// 제출한 숫자가 가장 큰 숫자를 가진 사람이 우승자
// 중위 표기법에서는 어긋나지 x, 피연산자는 999같은 3자리 수를 넘기지
// 않음

// 샌드박스
// 맵이 순서대로 보장을 해주지않지않나??
// 아마 큐 자료구조를 써야될것같은데
// 근데 우리가 중간에 있는 값들을 뽑아서 써야되기에 리스트를 써야됨
// 경우의 수를 탐색하기 위해서는 2가지 방법이 생각나는데
// dfs나 브루트포스? 6가지의 경우만 나올꺼니깐 고민임
// 계산 로직 스케치는 우선 순위 큐가 여기서 되는지 모르겠는데
// 연산자라 이건 좀 더 고민이 필요할듯함

import java.util.ArrayList;
import java.util.List;

class MaximizeExpression {
    public long solution(String expression) {
        long maxReward = 0;
        char[][] properties = {{'+','-', '*'},{'+','*','-'}
                ,{'-', '+', '*'},{'-','*', '+'},
                {'*','+', '-'}, {'*','-', '+'}};

        List<Long> numbers = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '*' || c == '+' || c == '-'){
                chars.add(c);
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
            else
                sb.append(c);
        }
        numbers.add(Long.parseLong(sb.toString()));

        for (char[] property : properties) {
            List<Long> cpNumbers = new ArrayList<>(numbers);
            List<Character> cpChars = new ArrayList<>(chars);

            for(int k = 0; k<3; k++)
            {
                char op = property[k];
                for(int j = 0; j<cpChars.size();)
                {
                    if(cpChars.get(j) == op)
                    {
                        long num1 = cpNumbers.get(j);
                        long num2 = cpNumbers.get(j+1);

                        long res = calc(num1, num2, op);

                        cpNumbers.remove(j+1);
                        cpNumbers.remove(j);
                        cpChars.remove(j);
                        cpNumbers.add(j, res);
                    }
                    else
                        j++;
                }
            }
            long finalReward = Math.abs(cpNumbers.get(0));
            maxReward = Math.max(maxReward, finalReward);
        }
        return maxReward;
    }

    private long calc(long num1, long num2, char op) {
        long res = 0;

        if(op == '+')
        {
            res = num1 + num2;
        }
        else if(op == '-')
        {
            res = num1 - num2;
        }
        else if(op == '*')
        {
            res = num1 * num2;
        }

        return res;
    }
}
