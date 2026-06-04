package Day92;

// 인사고과
// 완호네 회사는 연말마다 1년간의 인사고과에 따라 인센티브를 지급한다
// 각 사원마다 근무 태도점수와 동료평가 점수가 기록되어있는데
// 만약 어떤 사원이 다른 임원의 사원보다 두 점수가 낮은 경우가
// 한번이라도 있다면 그 사원은 인센티브를 받지 못한다

// 그렇지 않은 사원들에 대해서는 두 점수의 합이 높은 순서대로
// 석차를 내어 석차에 따라 인센티브를 지급한다.
// 이때 두 점수의 합이 동일한 동 석차이면 다음 석차는 건너 뛴다
// 각 사원의 근무태도 점수와, 동료평가 점수 목록이 scores로
// 주어질 때 완호의 석차를 리턴하도록 하시오

// 첫번쨰가 완호의 점수이고 (인사고과 점수가 두 파트에서
// 완호보다 낮은 사람을 찾아야함) -> 이 사람은 탈락하고
// 이제 사람들의 점수 합산이 높은 순대로 정렬하고
// 노드라는 클래스를 하나 만들어서 근무 점수, 동료 점수를 저장시키고
// 걔를 합산된값으로 정렬시키는데 사용하면 될것같은데

// 완호보다 낮은 사람이 아니라 회사 전체를 기준으로 삼아야함
// 회사 전체에서 나보다 두 점수가 높은 사원이 한명이라도 존재하면 탈락
// 인 느낌이고
// 사원수가 최대 10만이기떄문에 하나하나 다 비교하기엔 시간 초과문제가
// 생길 위험이 있음
// 자바 정렬 조건에 다중조건으로 정렬이 직접 가능함 그걸 통해
// 한번 순회하면 찾아낼수 있음
// 근무 점수를 일단 내림차순으로 하고, 동료평가 점수는 오름차순으로,
// 근무 점수같으면 동료 점수가 작은 놈부터

import java.util.Arrays;

class PersonnelEvaluation {
    public int solution(int[][] scores) {
        int wanhoWork = scores[0][0];
        int wanhoPeer =  scores[0][1];
        int wanhoScore = wanhoWork + wanhoPeer;

        Arrays.sort(scores, (a,b) ->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });

        int maxPeer = 0;
        int rank = 1;

        for (int[] score : scores) {
            int work = score[0];
            int peer = score[1];

            if(peer < maxPeer){
                if(peer == wanhoPeer && work == wanhoWork){
                    return -1;
                }
            }
            else{
                maxPeer = Math.max(maxPeer, peer);
                if (work + peer > wanhoScore){
                    rank++;
                }
            }
        }
        return rank;
    }
}