package Day1;

import java.util.HashSet;

public class Ponketmon {
    public int solution(int[] nums) {
        // 종류 개수 (중복 제외)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = nums.length/2;
        int typeCount = set.size();

        int answer = max > typeCount ? typeCount : max;
        return answer;
    }
}
