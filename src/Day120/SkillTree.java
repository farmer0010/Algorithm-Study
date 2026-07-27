package Day120;

// 스킬 트리

// 선행 스킬은 어떤 스킬을 배우기전에 먼저 배워야하는 스킬

// 선행 스킬에 속하지 않은 다른 스킬은 순서에 상관없이
// 배울수 있음
// 선행 스킬 순서 skill과 유저들이 많은 스킬을 담은 배열
// skill_tree가 주어질때 가능한 스킬트리 개수를 구하시오

// 스킬은 알파벳 대문자로만 이루어짐

// 샌드 박스
// 선행 스킬 순서가 핵심
// 앞에 스킬이 먼저 나왔는지 파악하느게 필요하고
// 스킬 문자가 다 포함될 필요는 없다라는걸 알아야함

// 생각한건 스킬 문자열을 문자 배열로 쪼갬 그리고
// skill_tree에 문자랑 비교해서 이 문자배열에 없는
// 문자는 다 "" 이렇게 바꿔버림 그리고 문자가 같은지 체크?

// 접두사 확인 할때는 startWiths 함수를 활용해보자

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skill_str = new String[skill_trees.length];
        int index = 0;

        for(String s : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(skill.indexOf(c) != -1){
                    sb.append(c);
                }
            }
            String str = sb.toString();
            skill_str[index++] = str;
        }

        for(String s : skill_str){
            if(skill.startsWith(s)){
                answer++;
            }
        }

        return answer;
    }
}

