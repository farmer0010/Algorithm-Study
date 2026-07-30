package Day121;

// 비내림차순으로 정렬된 수열이 주어질 떄 다음 조건을 만족하는 부분 수열을 찾으려고한다

// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열
// 부분 수열의 합은 k이 이고
// 합이 k인 부분 수열이 여러개인 경우 길이가 짧은 수열을 찾는다
// 길이가 짧은 수열이 여러개일 경우 앞쪽에 나오는 수열을 찾는다

class SequenceSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE;

        while(right < sequence.length)
        {
            if(sum == k){
                int curLen = right - left;
                if(curLen < minLen){
                    answer[0] = left;
                    answer[1] = right;
                    minLen = curLen;
                }
                sum -= sequence[left];
                left++;
            }
            else if(sum > k){
                sum -= sequence[left];
                left++;
            }
            if(sum < k){
                right++;
                if(right < sequence.length){
                    sum += sequence[right];
                }
            }
        }
        return answer;
    }
}