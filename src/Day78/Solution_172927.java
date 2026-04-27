package Day78;

// 광물 캐기

// 마인은 광석을 캐려고함
// 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이 각각 0개에서
// 5개 가지고 있음
// 곡괭이로 광물을 캘 때 피로도는 아래와 같음
// 다이아몬드 곡괭이로는 광물을 캐는 1,1,1
// 철 곡괭이로는 5,1,1
// 돌 곡괭이로는 25,5,1

// 각 곡쾡이는 종류에 상관없이 광물 5개를 캔후에는 더이상 사용할수 x
// 규칙: 최소한의 피로도로 광물을 캐야함
// 1. 사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캠
// 2. 한번 사용하기 시작한 곡괭이는 사용할 수 없을때까지 캐야함
// 3. 광물은 주어진 순서대로만 캘수 있음
// 4. 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을때까지
// 광물을 캠

// 갖고있는 곡괭이 갯수를 나타내는 정수 배열 picks (다이아, 철, 돌)
// 이 순서로 갯수 연결됨
// 광물의 순서를 담아둔 문자열 배열 minerals
// 마인이 작업을 끝내기까지 필요한 최소한이 피로도를 return해야함

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_172927 {
    class MineralChunk implements Comparable<MineralChunk>{
        int diaCnt;
        int ironCnt;
        int stoneCnt;

        int stoneFatigue;

        public MineralChunk(int diaCnt, int ironCnt, int stoneCnt) {
            this.diaCnt = diaCnt;
            this.ironCnt = ironCnt;
            this.stoneCnt = stoneCnt;
            this.stoneFatigue = (diaCnt*25) + (ironCnt *5) + stoneCnt;
        }

        @Override
        public int compareTo(MineralChunk o) {
            // 내림차순임을  주의
            return o.stoneFatigue - this.stoneFatigue;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMineral = totalPicks * 5;
        List<MineralChunk> mineralChunks = new ArrayList<>();

        for(int i = 0; i < minerals.length && i < maxMineral; i+=5){
            int dia = 0;
            int iron = 0;
            int stone = 0;

            for(int j = i; j < i + 5 && j < minerals.length; j++){
                if(minerals[j].equals("diamond")){
                    dia++;
                }
                else if(minerals[j].equals("iron")){
                    iron++;
                }
                else {
                    stone++;
                }
            }
            mineralChunks.add(new MineralChunk(dia, iron, stone));
        }
        Collections.sort(mineralChunks);
        for (MineralChunk chunk : mineralChunks) {
            if(picks[0] > 0){
                answer += chunk.diaCnt + chunk.ironCnt + chunk.stoneCnt;
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += (chunk.diaCnt *5) + chunk.ironCnt + chunk.stoneCnt;
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += chunk.stoneFatigue;
                picks[2]--;
            }
            else
                break;
        }
        return answer;
    }
}