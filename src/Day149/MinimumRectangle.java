package Day149;

// 최소 직사각형

// 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열이 주어질 떄
// 모든 명함을 수납할 수있는 가장 작은 지갑을 만들 때 지갑의 크기를 리턴하도록

// 일단 길이가 길지않기떄문에 브루트포스로 풀만한 것인데
// 적절히 회전 시켰을떄를 생각하면 배열의 순서를 바꿔서 두개의 가로 세로중 짧은걸 앞에 배치
// 긴걸 뒤에 배치

class MinimumRectangle {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[][] new_size = new int[sizes.length][sizes[0].length];

        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            new_size[i][0] = min;
            new_size[i][1] = max;
        }

        int w_max = 0;
        int h_max = 0;

        for(int i = 0; i < new_size.length; i++){
            w_max = Math.max(w_max,new_size[i][0]);
            h_max = Math.max(h_max,new_size[i][1]);
        }

        answer = w_max * h_max;

        return answer;
    }
}
