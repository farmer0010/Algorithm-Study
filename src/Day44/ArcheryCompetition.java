package Day44;

// 양궁대회
// 라이언 vs 어피치
// 대회에서는 한 선수의 연속 우승보다는 다른 선수가 우승하길 기원
// 그래서 라이언에게 불리한 규칙 적용
// 규칙 1. 어피치가 화살 n발을 쏜 후 라이언이 n발 쏨
// 2. 점수를 계산
// 2-1 만약에 k점을 어피치 a발 맞혔고 라이언이 b발 맞쳤을때
// 더 많은 화살을 k점에 맞춘 사람이 점수를 가져감
// k점을 여러 발 맞쳐도 k점 보다 많은 점수를 가져가는게 아닌
// k점만 가져가는 것 유의
// a=b일 경우엔 어피치가 k점을 가져감 둘다 화살을 못맞춘 경우
// 어느 누구도 점수를 못가져감
// 최종 점수가 같을 경우 어피치가 우승
// n은 화살 수 , info 는 과녁 점수판
// 이떄 n발의 화살을 어떤 과녁 점수에 맞쳐햐는지를 10점부터
// 0점까지 순서대로 정수 배열에 return
// 라이언이 이길수 없거나 비기는 경우에는 -1 리턴

// 샌드박스
// 수가 그렇게 크지않기떄문에 재귀로 모든 조건을 따져야하지않나?
// dfs일것 같긴한데 배열을 보니 이해가 안되네
// 이걸 갯수 max로 따져야하나?

// 샌드박스 2
// 이 점수를 확실히 먹을 경우 어피치보다 1발 더쏜다
// 어설프게 1발,2발 쏴서 비기거나 지면 어피치가 점수를 챙겨가니
// 아예 0발을 쏘고 남은 화살을 다른 점수에 투자
// dfs에 필요한 매개변수는 일단 화살 갯수, 점수 기록
// 내가 어디에 위치한지?, 어피치 점수

class ArcheryCompetition {
    int maxDiff = 0;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(0, n, ryan, info);
        return answer;
    }

    private void dfs(int index, int n, int[] ryan, int[] info) {
        if (index == 11) {
            if (n > 0) {
                ryan[10] += n;
            }

            int ryanScore = 0;
            int apeachScore = 0;

            for (int i = 0; i <= 10; i++) {
                if (ryan[i] > info[i]) {
                    ryanScore += 10 - i;
                } else if (ryan[i] == 0 && info[i] == 0) {
                    continue;
                } else {
                    apeachScore += 10 - i;
                }
            }

            int diff = ryanScore - apeachScore;

            if (diff > 0 && diff > maxDiff) {
                maxDiff = diff;
                answer = ryan.clone();
            } else if (diff > 0 && diff == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > answer[i]) {
                        answer = ryan.clone();
                        break;
                    } else if (ryan[i] < answer[i]) {
                        break;
                    }
                }
            }

            if (n > 0) {
                ryan[10] -= n;
            }
            return;
        }

        if (n > info[index]) {
            ryan[index] = info[index] + 1;
            dfs(index + 1, n - ryan[index], ryan, info);
            ryan[index] = 0;
        }

        dfs(index + 1, n, ryan, info);
    }
}
