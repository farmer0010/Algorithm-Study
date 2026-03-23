package Day41;

// 연속 부분 수열 합의 갯수
// 연속 부분 수열의 합을 저장하는 것은 set에다가 넣어야할
// 것 같은데? 중복이 없어야하니깐
// 길이의 기준은 elements의 길이를 기준으로 잡으면 될것같고
// 어떻게 반복문을 돌려서 나오게 할지 고민해보자
// 길이 별로 더하려면 이중 루프?

// 샌드박스
// 원형 수열을 처리할 때 인덱스를 길이로 나눈 나머지를 통해
// 구한다

import java.util.HashSet;
import java.util.Set;

class ContinuousSubsequence {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        // i는 길이가 1,2..5일떄를 의미
        for(int i = 0; i < elements.length; i++)
        {
            // 거기서 부터 이동한 걸음 수?라고 생각하면 편함 -> 원형큐를 연속 순열 큐로 변경해서 계산시 나머지 연산을 활용하는게 좋아보임
            int sum = 0;
            for(int j = 0; j < elements.length; j++)
            {
                sum += elements[(i+j)%elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
