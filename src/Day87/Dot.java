package Day87;

// 점 찍기
// 좌표 평면을 좋아하는 진수는 x축과 y축이 직교하는
// 2차원 좌표 평면에 점을 찍고 있음
// 진수는 두 양의 정수 k,d가 주어질 떄 다음과 같이 점을 찍으려고함
// 원점으로부터 x 축 방향으로 a*k
// y축 방향으로 b*k 만큼 떨어진 위치에 점을 찍고
// 원점과 거리가 d를 넘는 위치에는 점을 찍지않는다

// 전에 풀었던 문제와 유사할수도 있는데 일단 느낌이 x좌표는 고정으로 하고
// y좌표만 이동 시켜 그 범위에 있는지 체크해야한다.
// 일단 원의 방정식 생각하면 x^2 + y^2 <= d^2인데
// y좌표값만 도출하면 y = Math.sqrt(d^2 - x^2)
// 그리고 크기를 생각해서 일단 long 타입으로 지정해주고 작업해야할듯?

// 점의 개수 최적화 : 간격이 k가 만약 3이라면 전체길이에 / k를 해주면
// 개수가 나오고 거기에 0까지의 갯수도 포함 시켜주면 +1 해주면 된다

class Dot {
    public long solution(int k, int d) {
        long answer = 0;
        long limit = (long)d * d;

        for (int x=0; x <= d; x += k){
            long maxY = (long)Math.sqrt(limit - ((long) x*x));
            answer += (maxY / k) + 1;
        }
        return answer;
    }
}
