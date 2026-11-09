package Day164;

// 입국심사

// 각 입국 심사대에 있는 심사관 마다 걸리는 시간이 다름
// 한 심사대에서는 동시에 한명만 심사를 할수있음
// 가장 앞에 서있는 사람은 비어있는 심사대로 가서 심사를 받을수 있음
// 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하려고함

class ImmigrationCheck {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long max_time = 0;
        long left = 1;

        for(int i = 0; i < times.length; i++){
            max_time = Math.max(max_time, times[i]);
        }
        long right = max_time * n;

        while(left <= right){
            long mid = (left + right) / 2;

            long count  = 0;
            for(int i = 0; i < times.length; i++){
                count += mid / times[i];
                if(count >= n)
                    break;
            }

            if(count >= n){
                right = mid -1;
                answer = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return answer;
    }
}
