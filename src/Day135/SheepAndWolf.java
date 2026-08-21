package Day135;

// 양과 늑대

// 이진 트리 모양의 초원의 각 노드에 늑대와 양이 한마리씩 놓여져있음
// 초원은 루트 노드에서 출발하여 각 노드를 돌아다니며 양을 모으려고함
// 각 노드를 방문 할때 마다 해당 노드에 있던 양과 늑대는 나를 따라옴
// 이 때 양의 수보다 늑대 수가 같거나 더 많아지면 바로 모든 양을 잡아먹음

// 중간에 양이 늑대에게 잡아먹히지않도록 하면서 최대한 많은 수의 양을 모아서 루트노드로
// 돌아와야함

// 각 노드에 있는 양 또는 늑대에 대한 정보가 담긴 배열을 info, 이진 트리의 각 노드들의 연결
// 관계를 담은 2차원 배열가 매개변수가 주어질때
// 문제에 제시된 조건에 따라 각 노드를 방문하면서 모을 수있는 양은 최대 몇마리인지?

// 샌드박스
// 일단 노드 클래스를 만들어서 부모노드, 자식 노드, 양과 늑대인지 상태를 표기하는 형태로
// 만들어보고,
// 그 형태를 가지고 길이를 생각해보면 dfs를 돌리면 되지않을까 생각이듬

import java.util.*;

class SheepAndWolf {
    boolean visit[];
    int answer = 0;
    List<Integer>[] children;
    List<Integer> candiate = new LinkedList<>();
    public int solution(int[] info, int[][] edges) {
        visit = new boolean[info.length];
        children = new List[info.length];

        for(int i = 0; i < info.length; i++){
            children[i] = new LinkedList<>();
        }

        int wolf_cnt = 0;
        int sheep_cnt = 0;

        if(info[0] == 0){
            sheep_cnt = 1;
        }
        else{
            wolf_cnt = 1;
        }


        // 인접 리스트로 노드 구성
        for(int i = 0; i < edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];

            children[parent].add(child);
        }
        candiate.addAll(children[0]);
        visit[0] = true;

        dfs_animal(wolf_cnt, sheep_cnt, info);

        return answer;
    }

    private void dfs_animal(int wolf, int sheep, int[] info){
        answer = Math.max(answer, sheep);
        List<Integer> snap_shot = new LinkedList<>(candiate);

        for(int i = 0; i < snap_shot.size(); i++){
            int c = snap_shot.get(i);
            if(info[c] == 0){
                sheep++;
            }
            else
                wolf++;

            if(wolf >= sheep){
                if(info[c] == 0){
                    sheep--;
                }
                else
                    wolf--;
                continue;
            }
            else{
                visit[c] = true;
                candiate.remove(Integer.valueOf(c));
                candiate.addAll(children[c]);
                dfs_animal(wolf, sheep, info);
                candiate.add(c);
                candiate.removeAll(children[c]);
                if(info[c] == 0){
                    sheep--;
                }
                else
                    wolf--;
                visit[c] = false;
            }
        }
    }
}
