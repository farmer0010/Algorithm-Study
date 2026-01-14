package Day18;

// 로봇 기능: 한번에 k칸을 앞으로 점프
// 로봇 기능(2): 현재까지 온거리 * 2 해당하는 위치로 순간이동
// k칸을 점프시 k만큼의 건전지 사용랑이 듬
// 순간이동을 하면 건전지 사용량 줄지 x

public class JumpTeleport {
    public int solution(int n) {
        int ans = 0;

        while (n != 0)
        {
            if(n%2 == 0)
                n = n/2;
            else
            {
                ans++;
                n--;
            }
        }
        return ans;
    }
}
