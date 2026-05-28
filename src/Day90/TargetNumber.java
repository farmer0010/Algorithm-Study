package Day90;

// 타켓 넘버 n개의 음이 아닌 정수들이 존재
// 이 정수들을 순서를 바꾸지않고 적절히 더하거나 빼서
// 타켓 넘버를 만들려고함
// 숫자가 담긴 배열 numbers와 타켓넘버 target이 매개변수로
// 주어질 때 숫자를 적절히 더하고 빼서 타켓 넘버를 만드는 방법의 수를
// 리턴

// 일단 dfs로 범위가 넓지않기떄문에 생각해도 될 것같은데
// 일단 target을 만났을떄 재귀가 종료되는 조건으로 해야되고
// -> 이문제의 교정점 -> 배열에 있는 숫자를 다 돌면서 종료 지점에서
// target과도 같은지 체크해야됨
// numbers 배열을 이제 니열하면서 숫자보다 작으면 더하고
// 커지면 뺴고 이런식으로 해야할듯 한데
// 이 문제의 교정점 -> 이건 그리디 방식에 가깝고 우리는 모든
// 경우의 수를 구해야됨

class TargetNumber {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);

    }
}