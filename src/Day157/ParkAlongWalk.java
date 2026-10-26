package Day157;

// 공원 산책

// 지나다니는 길을 'O' ,  장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서
// 로봇 강아지를 산책 하려함
// 명령은 [방향 거리] -> 이런식으로 나타남

// 로봇은 명령을 수행하기전에 다음 조건을 확인함
// 주어진 방향으로 이동할때 공원을 벗어나는지
// 주어진 방향으로 이동중 장애물을 만나는지 확인

class ParkAlongWalk {
    public int[] solution(String[] park, String[] routes) {

        int h = park.length;
        int w = park[0].length();

        int startX = 0;
        int startY = 0;

        for(int j = 0; j < h; j++){
            for(int i = 0; i < w; i++){
                if(park[j].charAt(i) == 'S'){
                    startY = j;
                    startX = i;
                }
            }
        }

        for(int k = 0; k < routes.length; k++){
            String[] route = routes[k].split(" ");

            String dir = route[0];
            int n = Integer.valueOf(route[1]);

            int tempX = startX;
            int tempY = startY;
            boolean flag = true;

            for(int s = 0; s < n; s++){

                if(dir.equals("E")){
                    int nx = tempX + 1;
                    int ny = tempY;

                    if((nx >= 0 && nx < w) && (ny >=0 && ny < h) && park[ny].charAt(nx) != 'X'){
                        tempX = nx;
                        flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(dir.equals("W")){
                    int nx = tempX - 1;
                    int ny = tempY;

                    if((nx >= 0 && nx < w) && (ny >=0 && ny < h) && park[ny].charAt(nx) != 'X'){
                        tempX = nx;
                        flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(dir.equals("N")){
                    int nx = tempX;
                    int ny = tempY - 1;

                    if((nx >= 0 && nx < w) && (ny >=0 && ny < h) && park[ny].charAt(nx) != 'X'){
                        tempY = ny;
                        flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(dir.equals("S")){
                    int nx = tempX;
                    int ny = tempY + 1;

                    if((nx >= 0 && nx < w) && (ny >=0 && ny < h) && park[ny].charAt(nx) != 'X'){
                        tempY = ny;
                        flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                startX = tempX;
                startY = tempY;
            }
        }

        int[] answer = new int[2];

        answer[0] = startY;
        answer[1] = startX;

        return answer;
    }
}