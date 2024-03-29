import java.io.*;
import java.util.*;

class Solution {
    
    static int n,m,vis[][],answer;
    static Queue<int[]> q;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static boolean check(int r, int c) {
        if (r>=0 && r<n && c>=0 && c<m && vis[r][c]==1) return true;
        else return false;
    }
    
    public static void dfs() {
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int tmpR = curr[0];
            int tmpC = curr[1];
            
            if (tmpR == n-1 && tmpC == m-1) break;
            
            for (int d=0; d<4; d++) {
                int nr = tmpR+dr[d];
                int nc = tmpC+dc[d];
                if (check(nr,nc)) {
                    vis[nr][nc] = vis[tmpR][tmpC]+1;
                    q.offer(new int[] {nr,nc});
                }
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        vis = new int[n][]; //0이면 벽 또는 방문
        q = new LinkedList<>();
                
        for (int i=0; i<n; i++) {
            vis[i] = Arrays.copyOf(maps[i],m);
        }
        
        vis[0][0] = 1;
        q.offer(new int[] {0,0});
        dfs();
        
        answer = vis[n-1][m-1];
        if (answer==1) return -1;
        else return answer;
    }
}