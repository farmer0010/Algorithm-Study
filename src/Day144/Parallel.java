package Day144;

// 평행

// 점 네 개의 좌표를 담은 이차원 배열 dots가 매개변수가 주어짐
// 주어진 네 개의 점을 2개씩 이었을 때 두 직선이 평행되는 경우가 있으면 1
// 두 직선이 평행되는 경우가 있으면 0을 리턴

// 샌드박스
// 1. 이걸 평행으로 보는 관점이 무엇일지 생각해보자
// 이건 가설이라 코드를 작성해봐야하긴한데 임의의 (x1, y1) (x2, y2) (x3, y3) (x4, y4)
// 가 있다할 때 저 두개를 쌍으로 연결 시켜본다고 하면 x축의 차이와 y축의 차이가 동일해야
// 평행으로 본다는 느낌이남
// 2. 근데 쌍을 지어을 때 경우의 수는 어차피 4개이기 떄문에 시간 복잡도에서 터질 경우는 없음
// 하다보니 기울기가 같은게 있는지 찾아 내는게 큰 축인거같음

class Parallel {
    public int solution(int[][] dots) {
        int answer = 0;

        int dx1 = dots[1][0] - dots[0][0];
        int dy1 = dots[1][1] - dots[0][1];
        int dx2 = dots[3][0] - dots[2][0];
        int dy2 = dots[3][1] - dots[2][1];

        int dx11 = dots[2][0] - dots[0][0];
        int dy11 = dots[2][1] - dots[0][1];
        int dx22 = dots[3][0] - dots[1][0];
        int dy22 = dots[3][1] - dots[1][1];

        int dx111 = dots[3][0] - dots[0][0];
        int dy111 = dots[3][1] - dots[0][1];
        int dx222 = dots[2][0] - dots[1][0];
        int dy222 = dots[2][1] - dots[1][1];

        if((dx1 * dy2 == dx2 * dy1) ||(dx11 * dy22 == dx22 * dy11) || (dx111 * dy222 == dx222 * dy111))
            answer = 1;

        return answer;
    }
}
