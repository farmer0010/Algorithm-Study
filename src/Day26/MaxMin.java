package Day26;

class MaxMin {
    public String solution(String s) {
        String[] answer = s.split(" ");

        // 최소값 최대값 초기화
        int minVal = Integer.parseInt(answer[0]);
        int maxVal = Integer.parseInt(answer[0]);

        for (int i = 1; i < answer.length; i++) {
            int num = Integer.parseInt(answer[i]);
            if (num < minVal) {
                minVal = num;
            }
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return minVal + " " + maxVal;
    }
}
