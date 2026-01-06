package Day15;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int totalColors = brown + yellow;
        for(int height = 3; height < totalColors; height++) {
            if(totalColors % height == 0)
            {
                int width = totalColors / height;
                if(width < height)
                {
                    continue;
                }
                if((width - 2)*(height -2) == yellow)
                    return new int[]{width, height};
            }
        }
        return new int[]{};
    }
}
