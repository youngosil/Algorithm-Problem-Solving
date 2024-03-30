import java.io.*;
import java.util.*;

public class Edge {
    int st,ed;
    Edge(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] edges= new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            edges[i] = new ArrayList<>();
        }
  
        for (int i=0; i<edge.length; i++) {
            int A = edge[i][0];
            int B = edge[i][1];
            edges[A].add(B);
            edges[B].add(A);
        }
        
        int[] dist = new int[n+1];
        dist[1] = 1; //방문처리, 처음 cnt를 1로 설정
        int pick = 1; int max = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while (pick<n) {
            int idx = q.poll();
            
            for (int num : edges[idx]) {
                if (dist[num]==0) {
                    dist[num] = dist[idx]+1;
                    q.offer(num);
                    pick++;
                    max = Math.max(max,dist[num]);
                }
            }
            
        }
        
        for (int i=1; i<n+1; i++) {
            if (dist[i]==max) answer++;
        }
        
        
        return answer;
    }
}