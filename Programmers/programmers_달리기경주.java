// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.1-%EB%8B%AC%EB%A6%AC%EA%B8%B0-%EA%B2%BD%EC%A3%BC

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> changing_players = new HashMap<>();

        for (int rank =0; rank <players.length; rank ++){
            changing_players.put(players[rank], rank);
        }

        for(String player : callings){
            int callingPlayerNum = changing_players.get(player);

            String beforePlayerName = players[callingPlayerNum - 1];

            players[callingPlayerNum-1] = player;
            players[callingPlayerNum] = beforePlayerName;

            changing_players.put(players[callingPlayerNum -1], callingPlayerNum -1);
            changing_players.put(players[callingPlayerNum], callingPlayerNum);

        }

        answer = players;

        return answer;
    }
}