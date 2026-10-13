package Day152;

class HarshadNumber {
    public boolean solution(int x) {
        boolean answer = true;

        String hazard_x = String.valueOf(x);

        int hazard = 0;

        for(int i = 0; i < hazard_x.length(); i++){
            char ch = hazard_x.charAt(i);
            int n = ch - '0';

            hazard += n;
        }

        if(x % hazard == 0){
            answer = true;
        }
        else{
            answer = false;
        }

        return answer;
    }
}
