package Day92;

// 전화번호 목록
// 전화번호에 적힌 전화번호중 한번호가 다른 접두어인 경우가
// 있는지 확인 하려고함

// 전화번호부에 적힌 전화번호 담음 배열 phone_book이
// 매개변수로 주어질때 어떤 번호가 다른 번호의 접두어인 경우 false
// 그렇지 않으면 true

// hash로도 문제를 해결할수있는 있는데
// 폰번호에 있는 문자열들을 hashSet에 넣어주고
// substring을 통해 문자열을 잘라서 앞에서 i번쨰 글자까지 비교하고
// 그 조각이 포함되어있는지 체크하는 방식도 존재함

import java.util.Arrays;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length - 1 ;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }
        return answer;
    }
}
