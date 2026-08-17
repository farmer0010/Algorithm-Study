package Day132;

// 체육 대회

// 쳬육 대회는 여러 종목에 대해 각 반의 해당 종목 대표가 1명씩 나와
// 대결하며 한 학생은 최대 한개의 종목 대표만 할 수있다
// 학생들마다 각 종모에 대한 능력은 다르지만 이 능력은 수치화 되어 미리 알수있고
// 각 종목 대표의 해당 종목에 대한 능력치의 합을 최대화하는 것이다

// 샌드박스
// 1. 그리디를 처음에 생각했으나 매 순간 최선의 수가 아닌 좀 더 크게 봐야된다고 생각이 듬
// 2. 일단은 분야별로 점수를 묶은 배열을 새로 만들어줘야할 것같음
// 3. 거기서 점수의 총합을 구함, 그리고 점수의 총합이 가장 낮은 곳에서 점수를 제일 높은
// 애를 뽑아오고, 그 다음 점수 총합이 높은 곳에서 점수가 두번째로 높은 애를 뽑아오고
// 그런식으로 돌려야 할 것같은 느낌?
// 이렇게 생각해보고 풀어봤는데 반례가 많음, 그래서 dfs로 뽀갠다음에 갱신시키는 구조로
// 가야할듯함

class SportsDay {
    int answer = 0;
    public int solution(int[][] ability) {
        int stuendt_cnt = ability.length;
        int sport_cnt = ability[0].length;

        boolean isVisit[] = new boolean[stuendt_cnt];

        dfs_sport(0, 0, ability, isVisit);

        return answer;
    }

    private void dfs_sport(int depth, int cur_sum, int[][] ability, boolean[] isVisit){
        if(depth == ability[0].length){
            answer = Math.max(answer, cur_sum);
            return ;
        }

        for(int i = 0; i < ability.length; i++){
            if(!isVisit[i]){
                isVisit[i] = true;
                dfs_sport(depth+1, cur_sum + ability[i][depth], ability, isVisit);
                isVisit[i] = false;
            }
        }
    }
}