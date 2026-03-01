package Day45;

// 연속된 부분의 수열 합
// 비내림차순으로 정렬된 수열이 주어질떄
// 조건:
// 1. 기존 수열에서 임의 두 인덱스의 원소와
// 그 사이의 원소를 포함하는 부분 수열이어야함
// 2. 부부 수열의 합은 k
// 합인 k인 부분 수열이 여러개인 경우 길이가 짧은 수열
// 을 찾아야함

// 샌드박스
// 1. 무기선택: 양방향 포인터?인가 그거 얘기하는건가?
// 2. 로직 스케치: 구간의 합이 k보다 작으면
// 그 옆에 인덱스까지 늘리고 구간의 합이 k보다 크면
// 뭐 인덱스 하나 줄여보고
// 근데 같은 경우엔 최소 회수의 위치를 리턴 해야하니깐
// Math.min으로 뭐해야하나?

class ConsecutiveSequenceSum {
    public int[] solution(int[] sequence, int k) {
        int bestleft = 0;
        int bestright = 0;
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while (right < sequence.length) {
            if(sum == k)
            {
                int len = right - left;
                if(len < minLen)
                {
                    bestleft = left;
                    bestright = right;
                    minLen = len;
                }
                sum -= sequence[left];
                left++;
            }
            else if(sum > k)
            {
                sum -= sequence[left];
                left++;
            }
            else if(sum < k)
            {
                right++;
                if(right < sequence.length)
                    sum += sequence[right];
            }
        }
        return new int[]{bestleft, bestright};
    }
}
