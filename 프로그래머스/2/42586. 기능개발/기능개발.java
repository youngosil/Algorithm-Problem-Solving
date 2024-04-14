import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> tmp = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // queue에 순차적으로 데이터 넣기
        for (int i=0; i<progresses.length; i++) {
            queue.offer(progresses[i]);
        }
        
        int idx = 0;
        out : while (!queue.isEmpty()) {
            
            int cnt = 0;
            int days = (100-queue.peek())/speeds[idx];
            if ((100-queue.peek())%speeds[idx]!=0) days++;
            
            while (!queue.isEmpty() && queue.peek()+speeds[idx]*days>=100) {
                queue.poll();
                cnt++;
                idx++;
            }
            
            tmp.add(cnt);

        }

        int[] answer = new int[tmp.size()];
        int start = 0;
        for (int num : tmp) {
            answer[start++] = num;
        }
        
        return answer;
    }
}