package Day8;

// 일단 총색깔을 더하고
// 그게 가로 * 세로  == 노란색 + 갈색

class Carpet {
    public int[] solution(int brown, int yellow) {
        int totalColor = brown + yellow;

        for(int height = 3; height < totalColor; height++) {
            if(totalColor % height == 0) {
                int width = totalColor / height;
                if(width < height) {
                    continue;
                }
                if((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{};
    }
}
