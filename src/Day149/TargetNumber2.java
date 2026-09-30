package Day149;

// 타켓 넘버
// 순서를 바꾸지않고 적절히 더하거나 빼서 타겟 넘버를 만들려고함
// 부호 - , + 만 통해 처리

class TargetNumber2 {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs_target(numbers, 0, 0, target);

        return answer;
    }

    public void dfs_target(int[] numbers, int sum, int index, int target){

        if(index == numbers.length){
            if(sum == target)
                answer++;
            return;
        }

        dfs_target(numbers, sum + numbers[index], index + 1, target);
        dfs_target(numbers, sum - numbers[index], index + 1, target);
    }
}
