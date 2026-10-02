package Day151;

// 주어진 숫자중 3개의 수를 더 했을때 소수가 되는 경우의 개수를 구하려고한다

// nums에 있는 숫자들중 서로 다른 3개를 골라 더했을때 소수가 되는 경우를 리턴
// 합 중 중복된 애가 들어가면 안되니 set에다가 넣어주면 될듯하고
// 소수 판별하는 함수가 들어가야함

class MakePrime {
    int answer = 0;
    public int solution(int[] nums) {

        dfs(0,0,0, nums);

        return answer;
    }

    public void dfs(int index, int sum, int count, int[] nums){
        if(count == 3){
            if(is_prime(sum))
                answer++;
            return ;
        }

        for(int i = index; i < nums.length; i++){
            dfs(i+1, sum + nums[i], count + 1, nums);
        }
    }

    public boolean is_prime(int n){
        if(n < 2)
            return false;

        for(int i = 2; i*i <= n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
