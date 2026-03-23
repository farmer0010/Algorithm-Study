package Day40;

// 전화번호 목록
// 한 번호가 다른 번호 접두어인 경우 확인하는 문제
// 리턴 값: 어떤 번호가 다른 번호의 접두어인 경우
// false 그렇지 않으면 true

// 같은 번호가 중복해서 들어있지 않은 경우 ? 해시로 풀어야하나?
// 예시값들을 보니 첫번째로 기준을 하고 시작해야하나?
// 아니면 각각 값들을 가지고 비교하면서 해야하나? 고민이 듬
// 샌드박스 힌트: 내 글자가 저 글자로 시작하나?
// startsWith 함수를 쓰면 된다함

import java.util.Arrays;

class PhoneBook_Sort {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length -1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }
        return answer;
    }
}
