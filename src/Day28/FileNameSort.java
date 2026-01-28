package Day28;

import java.util.Arrays;
import java.util.Comparator;

class FileNameSort {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = spiltFileName(o1);
                String[] file2 = spiltFileName(o2);

                int headCompare = file1[0].compareToIgnoreCase(file2[0]);
                if (headCompare != 0) {
                    return headCompare;
                }
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                return num1 - num2;
            }
        });
        return files;
    }

    private String[] spiltFileName(String fileName) {
        String head = "";
        String number = "";
        String tail = "";

        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < fileName.length(); i++) {
            if (Character.isDigit(fileName.charAt(i))) {
                idx1 = i;
                break;
            }
        }
        if (idx1 == -1) {
            return new String[]{fileName, "", ""};
        }
        idx2 = fileName.length();
        for (int i = idx1; i < fileName.length(); i++) {
            if (!Character.isDigit(fileName.charAt(i))) {
                idx2 = i;
                break;
            }
            if (i - idx1 >= 5) {
                idx2 = i;
                break;
            }
        }
        head = fileName.substring(0,idx1);
        number = fileName.substring(idx1, idx2);
        tail = fileName.substring(idx2);

        return new String[]{head, number, tail};
    }
}
