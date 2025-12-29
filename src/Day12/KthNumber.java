package Day12;

import java.util.Arrays;

class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int first = commands[i][0];
            int second = commands[i][1];
            int third = commands[i][2];

            int[] arr = Arrays.copyOfRange(array, first-1, second);
            Arrays.sort(arr);
            answer[i] = arr[third - 1];
        }
        return answer;
    }
}
