package Day4;

import java.util.HashMap;

class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map1 = new HashMap<>();
        // 내가 이해하는 걸로 s가 있으면 yearning 배열에서 점수를 가져오고 없으면 0
        for (int i = 0; i < name.length; i++) {
            map1.put(name[i], yearning[i]);
        }
        // 이제 photo 배열에서 이름 갯수를 가져올 친구가 필요
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String s = photo[i][j];
                sum += map1.getOrDefault(s, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}