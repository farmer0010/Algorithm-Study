package Day151;

// 전화 번호

// 전화번호부에 적힌 전화 번호 배열을 담은 phoebook이 매개변수로 주어질 때
// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false
// 그렇지 않으면 true

import java.util.Arrays;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            String str = phone_book[i];
            if(i == 0){
                if(phone_book[i+1].startsWith(str))
                    return false;
            }
            else{
                if(phone_book[i+1].startsWith(str)){
                    return false;
                }
            }
        }

        return answer;
    }
}
