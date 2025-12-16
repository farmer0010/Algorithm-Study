package Day5;

import java.util.HashMap;
import java.util.Map;

class RunningRace {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        for (String s : callings) {
            if(map.containsKey(s)){
                String player = players[map.get(s)];
                int rank = map.get(player);
                String front = players[rank - 1];

                players[rank - 1] = player;
                players[rank] = front;
                map.put(player, rank-1);
                map.put(front, rank);
            }
        }
        return players;
    }
}
