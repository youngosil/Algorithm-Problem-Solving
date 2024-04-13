import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for (String player : completion) {
            map.put(player, map.getOrDefault(player,0)+1);
        }
        
        for (String player : participant) {
            int tmp = map.getOrDefault(player,0);
            if (tmp==0) {
                answer += player;
                break;
            }
            map.put(player,--tmp);
            
        }

        return answer;
    }
}