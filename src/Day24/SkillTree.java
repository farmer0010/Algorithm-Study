package Day24;

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (char c : tree.toCharArray()) {
                if(skill.indexOf(c) > -1)
                    sb.append(c);
            }
            if(skill.indexOf(sb.toString()) == 0)
                answer++;
        }
        return answer;
    }
}
