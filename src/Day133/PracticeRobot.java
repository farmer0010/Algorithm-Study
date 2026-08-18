package Day133;

// 실습용 로봇

// 실습용 로봇을 이용해서 로봇 프로그래밍을 학습한다
// 실습용 로봇은 입력된 명령에 따라 x좌표와 y좌표로 표현되는 2차원 좌표 평면 위를
// 이동한다.

// 하나의 명령은 하나의 문자로 주어지며 각 명령어에 따라 로봇이 수행하는
// 일은 다음과 같이 4종류다
// R 오른쪽 90도 회전 L 왼쪽 90도 회전 G 한칸 전진 B 한칸 후진

// 주어진 명령어 들을 순서대로 모두 수행 한뒤 도착한 최종 위치의 자표값 x,y를 순서대로
// 담아서 최종 위치의 좌표값 x,y를 순서대로 배열에 담아서 리턴
// 초기 상태는 (0,0) 위치에 +y 축을 향하여 놓여있다.

// 일단 느낌이 방향을 기록하는 그게 필요할 것같은데

class PracticeRobot {
    int dy[] = {1, 0, -1, 0};
    int dx[] = {0, 1, 0, -1}; // 상 우 하 좌

    int[] answer = new int [2];
    public int[] solution(String command) {

        robot_move(command);

        return answer;
    }

    private void robot_move(String command){
        int d = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < command.length(); i++){
            char move_key = command.charAt(i);

            if(move_key == 'R'){
                d = (d + 1) % 4;
            }
            else if(move_key == 'L'){
                d = (d + 3) % 4;
            }
            else if(move_key == 'G'){
                if(d == 0 || d == 2){
                    y += dy[d];
                }
                else if(d == 1 || d == 3){
                    x += dx[d];
                }
            }
            else if(move_key == 'B'){
                if(d == 0 || d == 2){
                    y += -dy[d];
                }
                else if(d == 1 || d == 3){
                    x += -dx[d];
                }
            }
        }
        answer[0] = x;
        answer[1] = y;
    }
}
