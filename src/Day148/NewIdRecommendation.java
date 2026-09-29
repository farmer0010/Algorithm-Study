package Day148;

class NewIdRecommendation {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < new_id.length(); i++){
            char ch = new_id.charAt(i);
            sb.append(Character.toLowerCase(ch));
        }
        new_id = sb.toString();

        sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++){
            char ch = new_id.charAt(i);

            if(Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.'){
                sb.append(ch);
            }
        }
        new_id = sb.toString();

        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }

        if(new_id.startsWith("."))
            new_id = new_id.substring(1, new_id.length());
        if(new_id.endsWith("."))
            new_id = new_id.substring(0, new_id.length() -1);

        if(new_id.equals(""))
            new_id = "a";

        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith(".")){
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        if(new_id.length() <= 2){
            sb  = new StringBuilder();
            char ch = new_id.charAt(new_id.length() -1);

            sb.append(new_id.charAt(0));
            for(int i = 0; i < 2; i++){
                sb.append(ch);
            }

            new_id = sb.toString();
        }
        answer = new_id;

        return answer;
    }
}
