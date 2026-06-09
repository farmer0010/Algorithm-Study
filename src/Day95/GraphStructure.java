package Day95;

// 도넛과 막대 그래프
// 도넛 모양 그래프, 막대 그래프, 8자 모양 그래프들이 있음
// 이 그래프들은 1개 이상의 정점과 정점을 연결하는 단반향
// 간선으로 이루어짐

// 도넛 그래프 : 크기가 n인 도넛 모양 그래프는
// n개의 정점과 n개의 간선이 있음
// 도넛 모양 그래프는 아무 한 정점에서 출발해 이용한 적
// 없는 간선을 계속 따라가면 n-1개의 정점을 돌고
// 출발했던 정점으로 돌아오게 됨

// 막대 그래프 : 크기가 n인 막대모양 그래프는 n개의 정점과
// n-1개의 간선이 있고, 임의의 한 정점에서 출발해 간선을
// 계속 따라가면 나머지 n-1개의 정점을 한번씩 방문하게 되는
// 정점이 단 하나 존재함

// 8자 모양 그래프 : 크기가 n인 8자 모양 그래프는 2n+1개의 정점과
// 2n+2개의 간선이 있고 8자 모양 그래프는 크기가 동일한 2개의 도넛
// 모양 그래프에서 정점을 하나씩 골라 결합시킨 그래프이다

// 문제: 이 3가지 모양의 글프가 여러개 있고 이 그래프들과 무관한
// 정점을 하나 생성한뒤 각 모양의 그래프들을 임의의 정점 하나로
// 향하는 간선을 연결했다
// 그 후에 각 정점에 서로 다른 번호를 매겼고, 이때 그래프의 간선 정보가
// 주어지면 생성한 정점의 번호와 정점을 생성하기전 3가지 모양의 그래프 수를
// 구해야함

// 샌드박스 : 일단 생성된 정점의 수를 첫번째로 찾아야 할것 같은데
// 얘를 어떻게 찾아내야할지 고민을 해보는게 1순위 인것 같고
// 다음으로 위에 문제 설명과 같이 각 그래프마다 정점과 간선의 갯수를 세야하는데
// 이걸 처리해야하는 방법이 있을 것같은데 배열의 크기도 커서 감이 잘안옴

class GraphStructure {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // 1. 정점의 최대 번호 찾기
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, (Math.max(edge[0], edge[1])));
        }
        int in[] = new int[maxVertex+1];
        int out[] = new int[maxVertex+1];

        // 2. 화살표 갯수 누적하기 (시작 나가는 선과, 들어오는 선을 잡아주고
        // 거기에 맞게 갯수를 정리해줘야함)
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            out[from]++;
            in[to]++;
        }
        int createVertex = 0;
        for (int i =1; i<= maxVertex; i++) {
            if(out[i] >= 2 && in[i] == 0){
                createVertex = i;
                break;
            }
        }
        answer[0] = createVertex;
        for (int i = 1; i <= maxVertex; i++) {
            // 막대모양과, 8자 모영
            if(out[i] == 0 && in[i] > 0){
                answer[2]++;
            } else if (in[i] >= 2 && out[i]>=2) {
                answer[3]++;
            }
        }
        int donutGraph = out[createVertex] - answer[2] - answer[3];
        answer[1] = donutGraph;

        return answer;
    }
}
