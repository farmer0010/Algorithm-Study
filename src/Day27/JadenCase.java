package Day27;

class JadenCase {
    public String solution(String s) {
        String answer = "";
        // 소문자로 변환후 한문자씩 쪼개서 저장
        String[] sp = s.toLowerCase().split("");

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (String ss : sp) {
            if(ss.equals(" "))
            {
                flag = true;
                sb.append(" ");
            }
            else
            {
                if(flag)
                {
                    sb.append(ss.toUpperCase());
                    flag = false;
                }
                else
                    sb.append(ss);
            }
        }
        return sb.toString();
    }
}
