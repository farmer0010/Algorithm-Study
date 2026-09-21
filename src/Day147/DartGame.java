package Day147;

// 다트 게임

// 게임의 핵심 부분인 점수 계산 로직을 처리해야함

// 점수 계산 로직
// 1. 다트게임은 총 3회로 구성
// 2. 각 기회마다 얻을 수 있는 점은 10점
// 3. 점수와 함께 S, D , T이 있는데 각 영역 당첨시 제곱으로 계산된다
// 4. 옵션으로 스타상, 아차상 존재
// 스타상 당첨시 해당 점수와 바로전에 얻은 점수를 각 두배로 만듬
// 아차상은 당첨시 해당 점수가 - 됨
// 5. 스타상은 첫번째 기회에서 나올수도 있는데 이경우 첫번쨰 스타상의 점수만 2배만 됨
// 스타상의 효과는 다른 스타상과 중첩 될 수 있음 이 경우 스타상의 점수는 4배
// 6. 스타상은 아차상과 효과과 중첩될수도 잇음 이 경우 중첩된 아차상은 -2배가 됨

import java.util.*;

class DartGame {
    class Dart{
        int num;
        char bonus;
        char opt;

        public Dart(int num, char bonus, char opt){
            this.num = num;
            this.bonus = bonus;
            this.opt = opt;
        }
    }

    public int solution(String dartResult) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Dart> list = new ArrayList<>();

        for(int i = 0; i < dartResult.length(); i++){
            char ch = dartResult.charAt(i);

            if(Character.isDigit(ch)){
                sb.append(ch);
            }
            else if (ch == 'S' || ch == 'D' || ch == 'T'){
                int n = Integer.parseInt(sb.toString());
                list.add(new Dart(n, ch, ' '));
                sb = new StringBuilder();
            }
            else if(ch == '*' || ch == '#'){
                list.get(list.size() - 1).opt = ch;
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            Dart base = list.get(i);
            int total = 0;

            if(base.bonus == 'S'){
                total += base.num;
                lst.add(total);
            }
            else if(base.bonus == 'D'){
                total += (base.num * base.num);
                lst.add(total);

            }
            else if(base.bonus == 'T'){
                total += (base.num * base.num * base.num);
                lst.add(total);
            }
        }

        for(int i = 0; i < lst.size(); i++){
            Dart base = list.get(i);

            if(base.opt == '*'){
                if(i >= 1){
                    int prev_n = lst.get(i - 1);
                    int cur_n = lst.get(i);

                    lst.set(i - 1, prev_n * 2);
                    lst.set(i, cur_n * 2);
                }
                else
                    lst.set(i, lst.get(i) * 2);

            }
            else if(base.opt == '#'){
                int cur_n = lst.get(i);
                lst.set(i, -(cur_n));
            }
        }

        for(int n : lst){
            answer += n;
        }

        return answer;
    }
}
