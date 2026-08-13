package Day130;

// 길 찾기 게임

// 두 팀을 나누고 각 팀이 같은 곳을 다른 순서로 방문 하도록해서
// 먼저 순회를 마친팀이 승리하는 것

// 방문할 곳의 장소를 2차원 좌표 값을 구하고 각 장소를 이진 트리 노드가 되도록 구성
// 한뒤 순회 방법을 힌트로 주어 각 팀이 스스로 경로를 찾게 할예정

// 규칙 트리를 구성하는 모든 노드의 x,y 좌표 값은 정수이다
// 모든 노드는 서로 다른 x의 값을 가진다
// 같은 레벨에 있는 노드는 같은 y좌표를 가진다
// 임의의 노드 V의 왼쪽 서브 트리에 있는 모든 노드의 x의 값은 V의 x값 보다 작다
// 임의 노드 V의 오른쪽 서브트리에 있는 모든 노드의 x의 값은 V의 x값 보다 크다

// 노드로 구성된 이진트리를 전위 순회, 후회 순회 한 결과를 2차원 배열에 순서대로 담아야함

import java.util.*;

class PathFindingGame {
    class Node{
        int x;
        int y;
        int n;
        Node left;
        Node right;

        public Node(int x, int y, int n){
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new LinkedList<>();
        List<Integer> lList = new LinkedList<>();
        List<Integer> rList = new LinkedList<>();

        for(int i = 0; i < nodeinfo.length; i++){
            int nx = nodeinfo[i][0];
            int ny = nodeinfo[i][1];

            list.add(new Node(nx, ny, i + 1));
        }

        Collections.sort(list , (a,b) -> {
            return b.y - a.y;
        });

        Node root = list.get(0);
        for(int i = 1; i < list.size(); i++){
            insert(root, list.get(i));
        }

        preorder(root, lList);
        postorder(root, rList);

        int[][] answer = new int[2][list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[0][i] = lList.get(i);
            answer[1][i] = rList.get(i);
        }

        return answer;
    }

    private void insert(Node cur, Node newNode){
        while(true){
            if(cur.x > newNode.x){
                if(cur.left == null){
                    cur.left = newNode;
                    break;
                }
                else{
                    cur = cur.left;
                }
            }
            else{
                if(cur.right == null){
                    cur.right = newNode;
                    break;
                }
                else{
                    cur = cur.right;
                }
            }
        }
    }

    private void preorder(Node cur, List<Integer> list){
        if(cur == null)
            return ;
        list.add(cur.n);
        preorder(cur.left, list);
        preorder(cur.right, list);
    }

    private void postorder(Node cur, List<Integer> list){
        if(cur == null)
            return ;
        postorder(cur.left, list);
        postorder(cur.right, list);
        list.add(cur.n);
    }
}
