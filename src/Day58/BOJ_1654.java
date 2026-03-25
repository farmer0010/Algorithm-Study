package Day58;

// 랜선 자르기

// 오영식이 박성원 부름 -> 박성원이 캠프 때 쓸 N개의 랜선 만들어야함
// 자체적으로 K개의 랜선을 가지고 있는데 길이가 다 재각각임
// 박성원은 모두 N개의 같은 길이의 랜선을 만들고 싶어서
// K개의 랜선을 잘라서 만들어야함
// 이미 자른 랜선은 붙일수 x

// 랜선을 자르거나 만들 떄 손실 되는길이는 없다고 가정
// 기존 K개의 랜선으로 N개의 랜선은 만들수 없다고 가정
// N개 보다 많이 만드는 것도 N개를 만드는 것에 포함

// 리턴값 : 만들수 있는 최대 랜선의 길이는?

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int max = 0;
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max){
                max = arr[i];
            }
        }
        long left = 1;
        long right = max;
        long result = 0;
        while(left <= right){
            long mid = (left + right)/2;
            long count = 0;
            for(int i = 0; i < K; i++){
                count += (arr[i]/mid);
            }
            if(count < N){
                right = mid - 1;
            }
            else{
                result = mid;
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
