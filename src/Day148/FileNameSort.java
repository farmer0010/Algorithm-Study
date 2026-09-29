package Day148;

import java.util.ArrayList;
import java.util.Collections;

class FileNameSort {
    class Word implements Comparable<Word>{
        String head;
        int number;
        String str;

        public Word(String head, int number, String str){
            this.head = head;
            this.number = number;
            this.str = str;
        }

        public int compareTo(Word o){
            if(this.head.equals(o.head)){
                return this.number - o.number;
            }
            return this.head.compareTo(o.head);
        }
    }

    public String[] solution(String[] files) {
        ArrayList<Word> list = new ArrayList<>();

        for(int i = 0; i < files.length; i++){
            String file = files[i];
            int idx = 0;

            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                idx++;
            }
            int startIdx = idx;

            while(idx < file.length() && Character.isDigit(file.charAt(idx)) && idx - startIdx < 5){
                idx++;
            }
            int endIdx = idx;

            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < startIdx; k++){
                sb.append(Character.toLowerCase(file.charAt(k)));
            }
            String head = sb.toString();
            int number = Integer.parseInt(file.substring(startIdx, endIdx));

            Word word = new Word(head, number, file);
            list.add(word);
        }
        Collections.sort(list);

        String[] answer = new String[list.size()];

        int index = 0;
        for(Word w : list){
            answer[index++] = w.str;
        }

        return answer;
    }
}
