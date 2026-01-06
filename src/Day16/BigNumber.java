package Day16;

class BigNumber {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 아직 지울 기회가 남아있는지 확인하고
            // sb에 글자가 있고
            // sb의 마지막 글자보다 지금 들어온 숫자가 더 크다며 마지막 숫자를 제거
            while (k>0 && sb.length() > 0 && sb.charAt(sb.length()-1) < c)
            {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(c);
        }
        return sb.substring(0, sb.length()-k);
    }
}
