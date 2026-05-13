package Day86;

// 쿼드 압축 후 개수 세기

// 0과 1로 이루어진 2^n * 2^n 2차원 정수 배열
// arr이 있는데 이걸 쿼드 트리 같은 방식으로 압축하고자 한다
// 구체적인 방식은 이러함
// 1. 내가 압축하고자 하는 특정 영역을 S라고 정의하고
// 2. 만약 S 내부에 있는 모든 수가 같은 값이 라면 S를 해당
// 수 하나로 압축 시킨다
// 3. 그렇지 않다면 S를 정확히 4개 균일한 정사각형 영역으로
// 쪼갠 뒤, 각 정사각형의 영역에 대해 같은 방식의 압축을 시도한다
// 위와 같은 방식으로 압축했을 때 배열에 최종적으로 남는 0의 개수와
// 1의 개수를 배열에 담아 리턴

// 일단 이걸 4개씩 어떻게 쪼개는지 봐야할 것같은데
// 그리고 4개의 사각형 안에 있는것도 숫자가 다 같다면
// 하나로 합쳐서 봐야되고 뭐 새로운 방식으로 생각해야되나?
// 아니면 구현 문제로 생각해야하나? 고민중임

class QuadCompression {
    int answer[] = new int[2];
    public int[] solution(int[][] arr) {
        quad(0,0,arr.length, arr);
        return answer;
    }

    private void quad(int x, int y, int length, int[][] arr) {
        if(check(x,y,length,arr)){
            answer[arr[x][y]]++;
            return;
        }
        int new_size = length / 2;
        quad(x,y,new_size, arr);
        quad(x+new_size,y,new_size, arr);
        quad(x,y+new_size,new_size, arr);
        quad(x+new_size,y+new_size,new_size, arr);
    }

    private boolean check(int x, int y, int length, int[][] arr) {
        int startNum = arr[x][y];

        for(int i = x; i < x+length; i++){
            for(int j = y; j < y+length; j++){
                if(arr[i][j]!=startNum){
                    return false;
                }
            }
        }
        return true;
    }
}
