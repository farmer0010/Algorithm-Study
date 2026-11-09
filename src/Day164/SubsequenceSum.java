package Day164;

// 연속된 부분의 수열의 합

// 오름차순으로 정렬된 수열이 주어짐
// 다음 조건을 만족하는 부분 수열을 찾아야함
// 1. 기존 수열에서 두 인덱스와 그 사이의 원소를 모두 포함하는 부분
// 수열이어야함
// 2. 부분 수열의 합은 k
// 3. 합이 k이 부분 수열이 여러개 인경우 길이가 짧은 수열을 찾음
// 4. 길이가 짧은 수열이 여러개 인경우 시작 인덱스가 낮은 수열을 찾음

// 위 조건을 만족하는 수열의 시작인덱스와 마지막 인덱스를 배열에 담아
// 리턴

// dfs를 통해서도 가능하지만 길이를 생각하면 불가능
// 그래서 left와 right를 통해서 진행하는게 좋아보임

class SubsequenceSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < sequence.length ; right++){
            sum += sequence[right];

            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            if(sum == k){
                int len = right - left + 1;
                if(len < minLen){
                    minLen = len;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }
}
