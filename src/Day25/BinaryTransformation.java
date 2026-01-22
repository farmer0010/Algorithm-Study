package Day25;

class BinaryTransformation {
    public int[] solution(String s) {
        int counter = 0;
        int removeZero = 0;

        while(!s.equals("1")) {
            counter++;
            int temp = s.length();
            s = s.replace("0", "");
            removeZero += temp - s.length();
            int len = s.length();
            // 길이를 이진수로 변환해야하는데 값을 다시 세야하니깐
            s = Integer.toBinaryString(len);
        }
        int[] answer = {counter, removeZero};
        return answer;
    }
}
