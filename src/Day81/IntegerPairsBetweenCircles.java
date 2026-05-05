package Day81;

// 두 원 사이의 정수 쌍
// x축과 y축으로 이루어진 2차원 직교 좌표계에
// 중심이 원점인 서로 다른 크기의 원이 두개 주어진다
// 반지름을 나타내는 정수 r1, r2가 매개변수로 주어질 때
// 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를
// return 하세요 (각 원 위의 점도 포함하여 세야함)

// 원의 방정식?으로는 코드를 뭔가 어떻게 건드려야할지 규칙을 찾아야할지
// 감이 좀 덜 오고
// 어차피 한 사문면 * 4를 해주면 총 개수가 나올꺼고
// 두원의 경계선에 있는애들은 올림 표현으로 포함되게 해야하지않을까..?
// 그림을 그려도 감이 잘안옴..

class IntegerPairsBetweenCircles {
    public long solution(int r1, int r2) {
        long answer = 0;
        int bigy = 0;
        int smally = 0;

        for (int x = 1; x <= r2; x++){
            bigy = (int)Math.floor(Math.sqrt((long)r2*r2 - (long)x*x));
            if (x < r1){
                smally = (int)Math.ceil(Math.sqrt((long)r1*r1 - (long)x*x));
            }
            else{
                smally = 0;
            }
            answer += (bigy - smally) + 1;
        }
        return answer * 4;
    }
}
