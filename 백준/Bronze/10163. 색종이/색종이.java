import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[1001][1001]; //격자배열생성
		
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[N+1]; //각 숫자가 몇 번 있는지 (=보이는 부분의 면적) cnt할 배열 생성
		
		// 1. 색종이를 격자배열에 색칠
		for (int n=1; n<=N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int R = Integer.parseInt(st.nextToken()); //행
			int C = Integer.parseInt(st.nextToken()); //열
			int H = Integer.parseInt(st.nextToken()); // 높이
			int W = Integer.parseInt(st.nextToken()); // 너비
			
			for (int r=R; r<R+H; r++) {
				for (int c=C; c<C+W; c++) {
					// 색종이가 들어오는 숫자대로 색깔을 칠함
					// 만약 겹쳐지면 나중에 오는 색으로 바뀌게 되는거임
					arr[r][c] = n; 
				}
			}
		}
		
		// 2. 각 색종이의 면적 구하기
		for (int r=0; r<1001; r++) {
			for (int c=0; c<1001; c++) {
				int index = arr[r][c];
				cnt[index]++; // 배열을 순회하면서 각 숫자가 적혀있는 횟수를 셈 = 넓이
			}
		}
		
		
		// 3. 출력
		for (int i=1; i<N+1; i++) {
			sb.append(cnt[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
