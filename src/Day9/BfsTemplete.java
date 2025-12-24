package Day9;

public class BfsTemplete {
    int answer = 0;

    public int BfsTemplete(int[] numbers, int target) {
        dfs(numbers, target, 0, 0); // 0번째 인덱스, 합계 0부터 시작
        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        // 수행동작: 다음 숫자를 더하고 다음 단계로 간다
        dfs(numbers, target, index + 1, sum + numbers[index]);
        // 수행동작: 다음 숫자를 뺴고 다음 단계로 간다.
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
