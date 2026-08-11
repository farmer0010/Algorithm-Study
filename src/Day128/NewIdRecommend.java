package Day128;

// 신규 아이디 추천

// 새로 가입하는 유저들이들이 카카오 아이디 규칙에 맞지않는 아이디를
// 입력했을 때 입력한 아이디와 유사하면서 규칙에 맞는 아이디를 개발해야함

// 1. 아이디 길이는 3자 이상 15자 이하
// 2. 아이디는 알파벳 소문자, 숫자, -, _, . 문자만 사용할 수 있음
// 3. 마침표는 처음과 끝에 사용될 수 없으며 또한 연속으로 사용될수 없다

// 과정
// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

// 문자열 재함수 공부, toLowerCase를 통한 소문자 변환
// startsWith, endsWith을 통한 접두사와 접미사에 무슨 문자로 시작되는지
// contains를 통해 특정 문자가 포함되는지
// 정규식 "[^ a-z0-9_.-]" -> 이러한 식으로 어떻게 이루어지는지

class NewIdRecommend {
    public String solution(String new_id) {

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");

        // 3단계
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }

        // 4단계
        if(new_id.startsWith(".")){
            new_id = new_id.substring(1);
        }
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0, new_id.length()-1);
        }

        // 5단계
        if(new_id.isEmpty()){
            new_id = "aaa";
        }

        // 6단계
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith("."))
                new_id = new_id.substring(0, new_id.length() -1);
        }

        // 7단계
        if(new_id.length() <= 2){
            char last = new_id.charAt(new_id.length() - 1);

            while (new_id.length() < 3) {
                new_id += last;
            }
        }

        System.out.println(new_id);


        return new_id;
    }
}
