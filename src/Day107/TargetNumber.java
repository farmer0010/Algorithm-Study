package Day107;

// 타켓 넘버
// n개의 음이 아닌 정수 들이 있고
// 이정수들을 순서를 바꾸지않고 적절히 더하거나 빼서
// 이 타켓 넘버를 만드려고 함

// 사용할 수있는 숫자가 담긴 배열 numbers와
// 타겟 넘버 target이 매개변수로 주어질 때
// 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 리턴

// 샌드박스
// 일단 주어지는 숫자가 많지 않으니 dfs로 해결 방법을 정의하고
// 종료조건은 target과 우리가 목표하는 수가 될 때까지 돌아야함

class TargetNumber {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs_target(0,0, numbers, target);

        return answer;
    }

    private void dfs_target(int index, int sum, int[] numbers, int target) {
        int n =  numbers.length;
        if(index == n){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs_target(index+1, sum+numbers[index], numbers, target);
        dfs_target(index+1, sum-numbers[index], numbers, target);
    }
}