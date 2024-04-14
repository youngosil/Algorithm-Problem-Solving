import java.io.*;
import java.util.*;

class Solution {
    
    static Map<Integer,List<Integer>> map = new HashMap<>();
    static Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int n, int[][] edge) {
        
        boolean[] vis = new boolean[n+1];
        boolean[][] adj = new boolean[n+1][n+1];
        for (int r=0; r<edge.length; r++) {
            int x = edge[r][0];
            int y = edge[r][1];
            
            adj[x][y] = true;
            adj[y][x] = true;
        }
        
        // 일단 node 1부터 처리
        vis[1] = true;
        queue.offer(new int[] {1,0});
        for (int i=1; i<n+1; i++) {
            if (!vis[i] && adj[1][i]) {
                vis[i] = true;
                queue.offer(new int[] {i,1});
            } 
        }
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (map.get(tmp[1])==null) {
                map.put(tmp[1],new ArrayList<>());
            }
            
            map.get(tmp[1]).add(tmp[0]);
            
            for (int i=1; i<n+1; i++) {
                if (!vis[i] && adj[tmp[0]][i]) {
                    vis[i] = true;
                    queue.offer(new int[] {i,tmp[1]+1});
                }  
            }

        }
        
        int maxKey = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            maxKey = Math.max(maxKey, key);
        }
                
        return map.get(maxKey).size();
    }
}