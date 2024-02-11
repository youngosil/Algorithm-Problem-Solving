import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1,1 ~ 99,99까지 색칠 가능. 
		// 상하좌우 한 칸씩 늘린 2차원배열 생성
		int[][] arr = new int[101][101]; 
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int cnt =0;
		
		for (int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			// 사각형 크기만큼 1로 색칠
			for (int c=C; c<C+10; c++) {
				for (int r=R; r<R+10; r++) {
					arr[r][c]=1;
				}
			}
		}

		int sum=0;
		for (int r=1; r<100; r++) {
			for (int c=1; c<100; c++) {
				// 만약 색칠되어 있을 때 한 면이라도 바깥과 맞닿으면 둘레.
				// 바깥과 닿아있는지 여부는 상하좌우에 0이 있는가로 판단.
				// 단, 가장 끝쪽에 위치할 때는 둘레. (예외)
				if (arr[r][c]==1) {
					for (int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						if (arr[nr][nc] ==0 || nr<0 || nr>100 || nc<0 || nc>100) {
							cnt++;
						}
						
//						if (nr>=1 && nr<=99 && nc>=1 && nc<=99) {
//							if (arr[nr][nc]==0) {
//								cnt++;
//								break;
//							}
//						} else if (nr==0 || nr==100 || nc==0 || nc==100) {
//							cnt++;
//							break;
//						}
					}
				}
			}
		}
		
		// 최대 수 출력
		System.out.println(cnt);
		
	}

}
