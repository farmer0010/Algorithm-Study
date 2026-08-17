package Day132;

// 유전 법칙

// 1. 둥근 완두 순종(PR)을 자가 수분 즉 같은 유전자끼리 교배할 경우
// 다음 세대에 둥근 완두 순종 형질만 나타난다.
// 2. 주름진 완두 순종 (rr)을 자가 수분 할 경우 다음 세대에 주름진 완두 순종 형진만
// 나타난다
// 3. 두 순종을 교배한 잡종(Rr)을 자가 수분할 경우, 다음세대의 형질은
// RR:Rr:rr=1:2:1의 비율로 나타난다

// 완두콩의 자가 수부 실험 결과를 정리하고자 함, 하지만 세대를 거듭할수록 완두콩의 수가 많아져
// 모든 가계도를 기록하기 어려워짐
// 그래서 가계도를 전부 기록하는 것 대신, 완두콩의 세대와 해당 세대에서 몇번째 개체인지를
// 알면 형질을 바로 계산하는 프로그램을 만들려고함

// 형질을 알고싶은 완두콩의 세대를 나타내는 정수 n과 해당 완두콩이 세대네에서 몇번째
// 개체인지를 나타내는 정수가 p가 2차원 정수 배열 queries에 주어진다.

class Genetics {
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int i = 0; i < queries.length; i++){
            int n = queries[i][0];
            int p = queries[i][1];

            String res = genetics(n,p);
            answer[i] = res;
        }

        return answer;
    }

    private String genetics(int n, int p){
        if(n == 1){
            return "Rr";
        }
        String parent = genetics(n-1, (p-1)/4 + 1);
        if(!parent.equals("Rr")){
            return parent;
        }
        else{
            int num = (p-1) % 4;
            String[] gene = {"RR", "Rr", "Rr", "rr" };
            return gene[num];
        }
    }
}
