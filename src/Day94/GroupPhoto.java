package Day94;

// 단체 사진 찍기

// 소풍을 떠났고, 단체사진을 찍기 위해 카메라 앞에 일렬로 섬
// 그래서 배치를 해야함
// 예시 조건
// 1. 네오는 프로도와 나란히 서기를 원함
// 2. 라이언은 튜브와 적어도 3칸이상 떨어져서 서기를 원함
// 무지는 모두가 원하는 조건을 만족하면서도 다르게 서는
// 방법이 있지않을까 라고 생각함 각 프렌즈가 원하는 조건을
// 입력으로 받았을 때 모든 조건을 만족할수 있도록 서는 경우의 수를 계산

// 입력은 조건의 개수를 나타내는 정수 n, n개의 원소로 구성된 문자열 배열
// data로 주어짐
// 첫번째와 세번째 글자는 (a,c,f,j,m,n,r,t)로 각각 캐릭터를 의미함
// 1. 첫번째 글자와 세번째글자는 항상 다르다
// 2. 두번째 글자는 항상 ~이다
// 3. 네번째 글자는 (=, < , >) 셋중 하나이다 각각
// 같음 미만 초과를 나타냄
// 4. 다섯 번째 글자는 0 이상 6 이하의 정수 문자열이며 조건에 제시되는
// 간격을 의미한다 (이 때 간격은 두 프렌즈 사이에 있는 다른 프렌즈 수이다)

// 샌드박스
// 1. 처음으로 파싱이 필요한데 일단 , 문자를 기준으로 split으로 쪼개서
// 저 문자열 배열들을 저장해야함 (틀린 사유: 애초에 쪼개진 상태로 들어옴)
// 그리고 문자열을 돌면 쟤네 자체도 파싱하고 어떻게 조건을 걸어주고
// 그걸 dfs로 전체 조건의 수를 찾아야될 것같은데 이 부분을 어떻게
// 코드로 작성할지 고민 종료조건은 저 data를 다 돌때가 종료 조건이겠고 (오류)
// dfs 종료조건은 8명의 멤버가 다 줄을 섰을때임
// 쟤네를 다 and 연산으로 조건을 맞쳐줘야지 그게 경우의 수를 찾기 위한
// 방법이긴 할듯함

class GroupPhoto {
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited;
    int answer;

    public int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[friends.length];
        dfs_friends("", data);

        return answer;
    }

    private void dfs_friends(String line, String[] data) {
        if(line.length() == 8){
            if(check_conditons(line, data)){
                answer++;
            }
            return;
        }
        for(int i = 0; i < friends.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs_friends(line+friends[i], data);
                visited[i] = false;
            }
        }
    }

    private boolean check_conditons(String line, String[] data) {
        for (String cond : data) {
            char mem1 = cond.charAt(0);
            char mem2 = cond.charAt(2);
            char op =  cond.charAt(3);
            int gap = cond.charAt(4) - '0';

            int idx1 = line.indexOf(mem1);
            int idx2 = line.indexOf(mem2);

            int actualGap = Math.abs(idx1 - idx2) - 1;

            if(op == '='){
                if(actualGap != gap)
                    return false;
            }
            else if (op == '<') {
                if(actualGap >= gap)
                    return false;
            }
            else if (op == '>') {
                if(actualGap <= gap)
                    return false;
            }
        }
        return true;
    }
}
