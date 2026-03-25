package Day57;

// 세준이는 양수와 +,-를 가지고 식을 만듬
// 그리고 나서 괄호를 모두 지웠고 괄호를 적절히 쳐서
// 이 식의 값을 최소로 만들려고함

// 리턴 값: 최소값 리턴
// 숫자는 0~9, +, - 로만 이루어짐


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =  br.readLine();

        StringTokenizer st = new StringTokenizer(input, "-");
        int result = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            String token = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(token, "+");
            int tempSum = 0;

            while(st2.hasMoreTokens()){
                tempSum += Integer.parseInt(st2.nextToken());
            }
            if(result == Integer.MAX_VALUE){
                result = tempSum;
            }
            else
                result -= tempSum;
        }
        System.out.println(result);
    }
}
