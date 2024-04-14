import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] edges= new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int r=0; r<edge.length; r++) {
            int x=edge[r][0];
            int y=edge[r][1];
            edges[x].add(y);
            edges[y].add(x);
        }
        
        int[] dist = new int[n+1];
        dist[1] = 1;
        int pick = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int num : edges[1]) {
            dist[num] = dist[1]+1;
            pick++;
            queue.offer(num);
        }
        
        int max = 2;
        
        while (pick<=n && !queue.isEmpty()) {
            int idx = queue.poll();
            
            for (int num : edges[idx]) {
                if (dist[num]==0) {
                    pick++;
                    dist[num] = dist[idx]+1;
                    queue.offer(num);
                    max = Math.max(max,dist[num]);
                }
            }
        }
        
        for (int i=1; i<=n; i++) {
            if (dist[i]==max) answer++;
        }
        
        
        return answer;
    }
}