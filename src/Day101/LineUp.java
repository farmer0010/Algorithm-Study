package Day101;

// 줄 서는 방법

// n명의 사람이 일렬로 줄을 섬
// n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨짐
// 여기서 생각해야되는건 n팩토리얼이 그 n이라는 것에 나올수있는
// 경우의 수임
// 그중에 k는 우리가 이 사람을 나열하는 방법을 사전순으로 나열했을 때
// k번 쨰 방법에 있는 배열을 리턴하는것임

// 사전순으로 이걸 어떻게 나열할지 고민을 해봐야할 것같고
// n이 20까지라 하지만 이게 팩토리얼로 가면 말도안되게 커진단
// 말이지? 그 경우의 수를 반복문을 돌려 찾자니 시간을 오래걸리니
// dfs를 활용하여 일단 작업은 하되?
// 배열리스트를 사용해보는게 낫지않을까?

// 의견 : 팩토리얼의 규칙성을 생각해보자
// 맨 앞자리 숫자 하나를 고정하고 뒤에 남은 숫자를 줄 세우는 방법
// (n-1)!이 되눈거임

import java.util.ArrayList;

class LineUp {
    public int[] solution(int n, long k) {
        ArrayList<Integer> pool = new ArrayList<>();
        long[] factorial = new long[n+1];

        // 숫자 카드 주머니 채우기
        for(int i=1; i<=n; i++){
            pool.add(i);
        }

        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            factorial[i] = factorial[i-1]*i;
        }
        k--;

        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            long blockSize = factorial[n-1-i];
            int index = (int) (k / blockSize) ;
            answer[i] = pool.remove(index);

            k %= blockSize;
        }

        return answer;
    }
}