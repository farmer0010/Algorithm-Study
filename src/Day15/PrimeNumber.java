package Day15;

import java.util.HashSet;
import java.util.Iterator;

class PrimeNumber {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        recursive("", numbers);
        int answer = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if(isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }

    private void recursive(String comb, String others) {
        if(!comb.equals(""))
        {
            set.add(Integer.valueOf(comb));
        }
        for(int i = 0; i < others.length(); i++)
        {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        for(int i = 2; i*i <= n; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
