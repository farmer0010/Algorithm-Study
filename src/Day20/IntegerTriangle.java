package Day20;

class IntegerTriangle {
    public int solution(int[][] triangle) {
        // 1층(0번 인덱스는 어차피 숫자 하나니깐 건너뛰고 2층부터 시작)
        for(int i=1;i<triangle.length;i++)
        {
            for(int j=0;j<triangle[i].length;j++)
            {
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                }
                else if(j == triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else
                {
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
        }
        int answer = 0;
        for (int i : triangle[triangle.length-1]) {
            answer = Math.max(answer,i);
        }
        return answer;
    }
}
