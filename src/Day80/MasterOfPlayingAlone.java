package Day80;

// 혼자 놀기의 달인

// 숫자 카드 더미에는 총 100개의 카드가 존재

// 각 카드에는 1부터 100까지 숫자가 하나씩 적혀있음
// 2이상 100 이하의 자연수를 하나 정해 그 수보다 작거나 같은 숫자
// 카드를 준비하고 준비한 카드 수만큼 작은 상자를 준비하면
// 게임을 시작할 수있음
// 그니깐 예시로 5를 정하면 5개의 상자가 필요하다는거 겟네

// 준비 된 상자에 카드를 한장 씩 넣고, 상자를 무작위로 섞어서
// 일렬로 나열함, 상자가 나열된 순서에 따라 1번부터 순차적으로
// 증가하는 번호를 붙임

// 그 다음의 임의 상자를 하나 선택하여 선택한 상자안의 숫자 카드를 확인
// 다음으로 확인한 카드에 적힌 번호에 해당하는 상자를 열어 담긴 카드에
// 적힌 숫자를 확인하고 이 과정을 계속 반복하면서 열어야 하는 상자가
// 이미 열려있을 때 까지 반복, 이렇게 연 상자들이 1번 상자 그룹

//이제 1번 상자 그룹을 다른 상자들과 섞이지 않도록 분리, 만약 1번
// 상자 그룹을 제외하고 남는 상자가 없으면 그대로 게임이 종료됨

// 그렇지 않다면 남은 상자중 중 다시 임의의 상자를 하나를 골라 같은 방식
// 으로 이미 열려있는 상자를 만날때 까지 염, 이렇게 연상자들이 2번 그룹

// 1번 상자 그룹에 속한 상자의 수와 2번 상자 그룹에 속한 상자 수를 곱한
// 값이 게임의 점수

// 상자안에 들어있는 카드 번호가 순서대로 담긴 배열 card가 매개 변수로
// 주어질떄 이 게임에서 얻을수 있는 최고 점수를 구해서 리턴

// 일단 중복되지않는 단어가 필요해야할것 같고 일단 인덱스 위치와
// 저 배열 안에 있는 값들을 매핑 시켜야하는 클래스를 만들어야되지않을까 싶고
// 해시 맵을 써야하나? 아니면 일단 값과 배열의 위치를 매핑 시켜서 돌리는게
// 핵심일 것같은데 일단 1번 상자를 세주는 카운트와 2번 상자를 세주는 카운트
// 먼저 만들어야하고

import java.util.ArrayList;
import java.util.Collections;

class MasterOfPlayingAlone {
    public int solution(int[] cards) {
        boolean[] isOpen = new boolean[cards.length+1];
        ArrayList<Integer> groups = new ArrayList<>();
        int answer = 0;

        int[] group = new int[cards.length+1];

        for(int i = 0; i < cards.length; i++){
            if(!isOpen[i]){
                int current = cards[i];
                int count = 0;
                while (!isOpen[current-1]){
                    isOpen[current-1] = true;
                    count++;
                    current = cards[current-1];
                }
                groups.add(count);
            }
        }
        if(groups.size()==1){
            return 0;
        }

        Collections.sort(groups, Collections.reverseOrder());
        answer = groups.get(0) * groups.get(1);

        return answer;
    }
}
