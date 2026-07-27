package Day120;

// 연속 된 부분의 수열의 합

// 비내림차순으로 정렬된 수열이 주어질때
// 다음 조건에 만족하는 부분 수열을 찾으려고 함

// 1. 기존 수열에서 임의의 두 인덱스 원소와 그 사이의 원소를 모두
// 포함하는 부분 수열이어야한다 .
// 2. 부분 수열의 합은 k이다.
// 3. 합인 k인 부분 수열이 여러개인 경우 길이가 짧은 수열을
// 찾습니다
// 4. 길이가 짧은 수열이 여러개인 경우 시작 인덱스가 낮은
// 수열을 찾는다.

// 투포인터를 사용하는 경우
// 데이터 개수 N이 엄청 크고
// 배열이 오름차순/내림 차순으로 정렬되있어 있거나
// 연속된 구간이라는 조건이 있다.
// 원소들이 양수 위주이다, 포인터를 오른쪽으로 옮기면 값이
// 무조건 증가하고, 왼쪽을 밀면 무조건 감소

class SequenceSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE;

        while(left<=right && right < sequence.length){
            if(sum == k){
                int curLen = right - left;
                if(curLen < minLen){
                    minLen = curLen;
                    answer[0] = left;
                    answer[1] = right;
                }
                right++;
                if(right < sequence.length){
                    sum += sequence[right];
                }
            }
            else if(sum < k){
                right++;
                if(right < sequence.length){
                    sum += sequence[right];
                }
            }
            else{
                sum -= sequence[left];
                left++;
            }
        }



        return answer;
    }
}
