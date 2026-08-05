package Day125;

// n명이 입국 심사를 위해 줄을 서서 기다림
// 각 입국 심사대에 있는 심사관 마다 심사하는데 걸리는 시간이 다름
// 처음에 모든 심사대는 비어있음
// 한 심사대에서는 동시에 한명만 심사를 할 수있음
// 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서
// 심사를 받을 수도 있음

// 모든 사람들이 심사를 받는데 걸리는 시간을 최소로 함

// 샌드박스
// 1. 처음에 그리디를 생각했지만 그리디는 매 순간의 최선의 선택이기 때문에
// 좀 크게 보고 해결 할 수 없음
// 2. 이분 탐색이라는 힌트를 받았는데 이분 탐색으로 하면 그 시간을 가지고 탐색하는건가?
// 생각이 드는정도?
// 가장 최선의 시간 초기값과 가장 최악의 시간 초기값은 min과 max를 활용하면 되지않을까?

class ImmigrationInspection {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = Integer.MAX_VALUE;
        long right = 0;

        if(times.length == 1)
            return times[0] * n;

        for(int i = 0; i < times.length -1; i++)
        {
            left = Math.min(left, Math.min(times[i], times[i+1]));
            right = Math.max(right, Math.max(times[i], times[i+1]));
        }
        right = right * n;

        while(left <= right){
            long mid = (left + right) / 2;
            long person = 0;

            for(int i = 0; i < times.length; i++){
                person += (mid / times[i]);
            }
            if(person >= n){
                answer = mid;
                right = mid -1;
            }
            else
                left = mid +1;
        }
        return answer;
    }
}
