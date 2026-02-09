package Day34;

// 이모티콘 플러스 서비스 가입자를 최대한 늘리는것 (1)
// 이모티콘 판매액을 최대한 늘리는 것 (2)
// n명의 카톡 사용자에게 m개를 할인하여 팜
// 이모티콘 구매 비용이 10000원이 넘으면 취소되고 이모티콘 플러스 가입
// 카카오톡 사용자 n명 구매기준을 담은 users 배열 (비율, 가격)
// 이모티콘 m개의 정가를 담은 배열

class EmoticonDiscount {
    static int rate[] = {10, 20, 30, 40};
    static int maxUsers = 0;
    static int maxSales = 0;
    static int[] discounts;

    public int[] solution(int[][] users, int[] emoticons) {
        discounts = new int[emoticons.length];
        dfs(0, users, emoticons);
        return new int[]{maxUsers, maxSales};
    }

    private void dfs(int depth, int[][] users, int[] emoticons) {
        // 1. 종료조건: 모든 이모티콘의 할인율이 정해진다면?
        if (depth == emoticons.length) {
            calculate(users, emoticons);
            return;
        }
        for (int i = 0; i < 4; i++) {
            discounts[depth] = rate[i];
            dfs(depth + 1, users, emoticons);
        }
    }

    private void calculate(int[][] users, int[] emoticons) {
        int plusCount = 0; // 이번 조합의 가입자 수
        int totalSales = 0; // 이번 조합의 판매액

        // [1] 모든 유저 반복
        for (int[] user : users) {
            int userRate = user[0];
            int userLimit = user[1];
            int sum = 0; // 이 유저의 장바구니 총액

            // [2] 이모티콘 쇼핑 (안쪽 for문)
            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userRate) {
                    sum += emoticons[i] * (100 - discounts[i]) / 100;
                }
            } // ★ 여기서 안쪽 for문 끝! (쇼핑 끝)

            // [3] 계산대 (안쪽 for문 밖에서 판단!)
            // 여기서 sum과 userLimit을 비교하세요.
            if (sum >= userLimit) {
                plusCount++; // 예산 초과 -> 플러스 가입
            } else {
                totalSales += sum; // 예산 이내 -> 그냥 구매 (전체 매출에 추가)
            }
        } // ★ 여기서 바깥 for문 끝! (모든 유저 조사 끝)

        // [4] 최종 기록 갱신 (유저 반복문이 다 끝난 뒤)
        if (plusCount > maxUsers) {
            maxUsers = plusCount;
            maxSales = totalSales;
        } else if (plusCount == maxUsers) {
            // 가입자 수가 같으면, '판매액'이 더 클 때만 갱신!
            if (totalSales > maxSales) {
                maxSales = totalSales;
            }
        }
    }
}
