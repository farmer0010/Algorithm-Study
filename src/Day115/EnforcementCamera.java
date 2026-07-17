package Day115;

// 단속 카메라

// 모든 차량이 고속도로를 이용하면서
// 단속용 카메라를 만도록 한번을 설치하려고함
// 고속도로를 이용하는 차량의 경로 route가 매개 변수로
// 주어질 때 모든 차량이 한번은 단속용 카메라를 만나도록
// 하려면 최소 몇대의 카메라를 설치해야하는지
// route[i][0]은 i번째 차량이 고속도로에 진입한 지점
// route[i][1]은 i번째 차량이 고속도록에 나간 지점

// 차량 잔압, 진출 지점에 설치되어있어도 카메라를 만난걸로
// 생각하면됨

// 샌드 박스
// 샌드 박스를 그려보니 요격 시스템과 아주 유사하지만
// 얘는 x,y 좌표가 아니다 보니 일단 그림을 그려봄
// 진출 지점이 다음 좌표에 진입 지점에 포함되는지?
// 확인을 해야하는건가?

import java.util.*;

class EnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int cameraPos = -30001;

        for (int i = 0; i < routes.length ; i++) {
            if (routes[i][0] > cameraPos) {
                cameraPos = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
