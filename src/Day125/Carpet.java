package Day125;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for(int h = 3; h <= total; h++){
            int w = total / h;

            if((w - 2) * (h - 2) == yellow){
                return new int[]{w,h};
            }
        }

        int[] answer = {};
        return answer;
    }
}