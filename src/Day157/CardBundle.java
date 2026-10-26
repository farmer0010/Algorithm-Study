package Day157;

// 카드 뭉치

// 규칙
// 원하는 카드 뭉치에서 카드를 순서대로 한장씩 사용
// 한번 사용한 카드는 다시 사용할수 없음
// 카드를 사용하지 않고 다음 카드로 넘어갈수 X
// 기존에 주어진 카드 뭉치의 단어 순서는 바꿀수 X

class CardBundle {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int card1Idx = 0;
        int card2Idx = 0;

        for(int i = 0; i < goal.length; i++){
            if(card1Idx < cards1.length && goal[i].equals(cards1[card1Idx])){
                card1Idx++;
            }
            else if(card2Idx < cards2.length && goal[i].equals(cards2[card2Idx])){
                card2Idx++;
            }
            else{
                return "No";
            }
        }

        return answer;
    }
}
