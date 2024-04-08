import java.io.*;
import java.util.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N,board[][],result, direction, D[][], startR, startC, cnt;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static Map<Integer,List<int[]>> wormholes; //key = 웜홀 번호, value = 좌표 리스트 (원소 2개로 서로 1:1 대응)
    static List<int[]> startPoints; // 시작점 넣을 배열
    
    public static void dfs(int r, int c, int d) {
    	    	
    	int nr = r+dr[d];
    	int nc = c+dc[d];
    	
    	if (nr<0 || nr>=N || nc<0 || nc>=N) {
    		cnt++;
    		dfs(nr,nc,D[d][5]);
    	} else {
    		int next = board[nr][nc];
    		
    		//블랙홀이면 return + 시작 지점으로 돌아오면 return
    		if (next==-1 || (nr==startR && nc==startC)) {
    			result = Math.max(result,cnt);
    			return;
    		}
    		
    		// 만약 빈 공간이거나 블록이라면
    		if (next<=5) {
    			if (next>0) cnt++;
    			dfs(nr,nc,D[d][next]);
    		} 
    		//웜홀이라면
			else {
				List<int[]> wormhole = wormholes.get(next);
				int[] other = (wormhole.get(0)[0] == nr && wormhole.get(0)[1] == nc) 
						? wormhole.get(1)
						: wormhole.get(0);
				dfs(other[0], other[1], d);
			}
    	}
    	
    	
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        // 각 방향으로 가다가 만난 블록에 따라 다음 방향 정해줄 배열
        D = new int[4][6];
        D[0] = new int[] {0,1,3,2,1,1};
        D[1] = new int[] {1,3,0,0,2,0};
        D[2] = new int[] {2,0,1,3,3,3};
        D[3] = new int[] {3,2,2,1,0,2};
        
        for (int t=1; t<=T; t++) {
            
            N = Integer.parseInt(br.readLine().trim()); // 판의 크기
            wormholes = new HashMap<>();
            board = new int[N][N];
            startPoints = new ArrayList<>();
            
            // 판 입력받기
            for (int r=0; r<N; r++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int c=0; c<N; c++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    board[r][c] = tmp;
                    
                    // 0이면 시작점 리스트에 추가
                    if (tmp==0) startPoints.add(new int[] {r,c});
                    
                    // 웜홀이면 map에 추가
                    else if (tmp>=6) {
                        List<int[]> list = wormholes.getOrDefault(tmp, new ArrayList<>());
                        list.add(new int[] {r,c});
                        wormholes.put(tmp, list);
                    }
                    
                }
            }
                        
            result = 0;
            
            // 가능한 시작점 돌면서 핀볼 튕기기
            for (int[] departure : startPoints) {
                startR = departure[0];
                startC = departure[1];
                                
                for (int d=0; d<4; d++) {
                	cnt = 0;
                    dfs(startR,startC,d);
                }

            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        
        System.out.println(sb);
    }

}