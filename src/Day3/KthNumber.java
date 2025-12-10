package Day3;

import java.util.Arrays;

class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int []arr = new int[commands.length];

        for(int i = 0; i < commands.length; i++)
        {
            int first = commands[i][0];
            int last = commands[i][1];
            int index = commands[i][2];

            int[] ints = Arrays.copyOfRange(array, first-1, last);
            Arrays.sort(ints);
            arr[i] = ints[index -1];
        }
        int[] answer = arr;
        return answer;
    }
}
