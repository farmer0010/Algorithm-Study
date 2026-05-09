package Day84;

// 연속 부분 수열 합의 개수

// 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분
// 수열의 합으로 만들 수 있는 수가 모두 몇가지인지 구해야하는데
// 원형 수열이란 일반 적인 수열에서 처음과 끝이 연결된 형태의 수열을
// 말하고 원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에
// 연속하는 부분 수열도 일반적인 수열보다 많아진다

// 일단 중복된 값은 제거하고 경우의 수를 따져야되기 때문에
// 저장은 hashset 자체에 저장해야되지않을까 생각이 들고

// 일단 길이마다 수를 구해줘야됨
// 크기는 크지않기 떄문에 2중 for문으로 일단 해줘야할것같은데
// 어차피 그 갯수 만큼 반복되는거기 떄문에 % 처리를 해줘야할것 같음
// -> 피드백: 근데 차라리 배열의 길이를 2배로 늘려서 펴버리고
//

import java.util.HashSet;
import java.util.Set;

class ContinuousSubsequenceSum {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] doubleElement = new int[n * 2];

        for (int i = 0; i < n; i++) {
            doubleElement[i] =  elements[i];
            doubleElement[i + n] = elements[i];
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += doubleElement[i + j];
            }
            set.add(sum);
        }
        return set.size();
    }
}
