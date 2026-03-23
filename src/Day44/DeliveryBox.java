package Day44;

// 택배상자
// 영재가 실어야하는 택배상자는 크기같고 1번부터 n번 상자까지
// 번호가 증가하는 순서대로 컨베이어 벨트에 있음
// 하지만 컨테이너 벨트에 순서대로 내려서
// 싣게 되면 택배기사님이 배달하는 순서와 택배상자가 실려있는 순서가
// 맞지 x 따라서 택배 기사님이 미리 알려준 순서에 맞게 싣어야함

// 그래서 컨테이너 벨트에 실어야하는 순서가 아니라면
// 보조컨테이너 벨트에 보관해야함 (앞 뒤로 이동 가능)
// 하지만 입구말고는 막혀있어서 맨앞의 상자만 뺼수있음
// 즉 가장 마지막에 보조컨테이너벨트에 보관한 상자부터 꺼냄
// 만약에 이걸 사용해도 원하는 순서대로 되지않는다면 더 이상
// 상자를 싣지 X

// 샌드박스
// 원하는 대로 상자를 실지 못한다면 거기서 리턴
// 무슨 도구를 써야하나? 이건 100퍼 스택아닌가?
// 메인 컨베이어 밸트나 보조컨베이어 벨트나
// 스택을 가지고 비교해서 하면 될것같은데?
// order를 이터레이터로 돌리고 순서가 같으면 트럭에 싣고
// 순서가 같지않다면 보조 컨베이어 벨트로 보내고?

import java.util.Stack;

class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subBelt = new Stack<>();
        int orderIndex = 0;

        for (int i = 1; i <= order.length; i++) {
            subBelt.push(i);

            while (!subBelt.empty() && subBelt.peek() == order[orderIndex]) {
                subBelt.pop();
                answer++;
                orderIndex++;
            }
        }
        return answer;
    }
}
