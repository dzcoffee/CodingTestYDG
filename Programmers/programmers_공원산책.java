// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.1-%EA%B3%B5%EC%9B%90-%EC%82%B0%EC%B1%85

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        for(int j = 0 ; j<park.length; j++){
            int S_position = park[j].indexOf("S");
            if(S_position != -1){
                answer[0] = j;
                answer[1] = S_position;
                break;
            }
            else{
                continue;
            }
        }

        for(int i = 0 ; i< routes.length; i++){
            String[] route = routes[i].split(" ");
            String direction = route[0];
            int MoveNum = Integer.parseInt(route[1]);
            switch(direction){
                case "N" :
                    answer = move_check_y(MoveNum, -1, answer, park);
                    break;
                case "S" :
                    answer = move_check_y(MoveNum, +1, answer, park);
                    break;
                case "W" :
                    answer = move_check_x(MoveNum, -1, answer, park);
                    break;
                case "E" :
                    answer = move_check_x(MoveNum, +1, answer, park);
                    break;
            }
        }

        return answer;
    }

    private int[] move_check_y(int MoveNum, int way, int[] Position, String[] park){
        int now_Y = Position[0];
        for(int i =1; i<= MoveNum; i++){
            if(now_Y + (i * way) >= park.length || now_Y + (i * way) < 0 ){
                return Position; // 공원을 벗어나는 경우는 원래 Position 반환
            }
            else if (park[now_Y + (i * way)].charAt(Position[1]) == 'X'){
                return Position; //장애물을 만난 경우 원래 Position 반환
            }
            else{
                continue;
            }
        }
        Position[0] = Position[0] + (MoveNum * way);
        return Position;
    }

    private int[] move_check_x(int MoveNum, int way, int[] Position, String[] park){
        int now_X = Position[1];
        for(int i =1; i<= MoveNum; i++){
            if(park[Position[0]].length() <= now_X + (i * way) || 0 > now_X + (i * way)){
                return Position; // 공원을 벗어나는 경우는 원래 Position 반환
            }
            else if (park[Position[0]].charAt(now_X + (i*way)) == 'X'){
                return Position; //장애물을 만난 경우 원래 Position 반환
            }
            else{
                continue;
            }
        }
        Position[1] = Position[1] + (MoveNum * way);
        return Position;
    }
}