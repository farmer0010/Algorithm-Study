package Day149;

// 흩어진 종이 조각을 붙여 소수를 몇개 만들수 있는지 알아내려함

// 각 종이에 적힌 숫자가 적힌 문자열 numbers가 주어질 때 종이조각으로
// 만들 수 있는 소수가 몇개인지 리턴하도록 완성
// 결과는 중복을 저장하면 안되니 hashset으로

import java.util.*;

class FindPrimeNumber {
    HashSet<Integer> set = new HashSet<>();
    boolean[] check;

    public int solution(String numbers) {
        int answer = 0;
        check = new boolean[numbers.length()];

        dfs("", numbers, check);

        for(int n : set){
            if(is_prime(n)){
                answer++;
            }
        }

        return answer;
    }

    boolean is_prime(int n){
        if(n < 2)
            return false;

        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }


    void dfs(String str, String numbers, boolean[] check){
        if(!str.isEmpty())
            set.add(Integer.parseInt(str));

        for(int i = 0; i < numbers.length(); i++){
            if(check[i])
                continue;

            check[i] = true;
            dfs(str + numbers.charAt(i), numbers, check);
            check[i] = false;
        }
    }
}
