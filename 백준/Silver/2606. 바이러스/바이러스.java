import java.io.*;
import java.util.*;

public class Main {

	static int N, M, cnt;
	static boolean board[][],vis[];
	static StringTokenizer st;

	static void bfs(int r) {
		for (int c=1;c<=N;c++) {
			if (board[r][c] && !vis[c]) {

				cnt++; //감염 컴터 수 증가시키고
				vis[c] = true; // 밤문체크
				
				int temp = c; //변수명 똑같아서 그냥 temp로 해줌 (한거랑 안한거 차이는 모름)
				bfs(temp); // 열번호를 bfs의 키로 다시 넘김 (행으로 해서 탐색하게됨)
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 노드의 수
		board = new boolean[N + 1][N + 1]; // 방문이력 확인할 배열
		vis = new boolean[N+1];
		vis[1] = true;

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = true;
			board[b][a] = true;
		}

		bfs(1);
		System.out.println(cnt);

	}

}
