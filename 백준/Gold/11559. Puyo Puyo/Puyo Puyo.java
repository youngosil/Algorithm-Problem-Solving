import java.io.*;
import java.util.*;

class RC {
	int r,c;
	
	RC(int r, int c) {
		this.r=r;
		this.c=c;
	}
}

public class Main {
	
	static char[][] board;
	static boolean[][] vis;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int combo;
	static boolean blow;
	static Queue<RC> queue,tmpQueue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		vis = new boolean[12][6];
		
		// 일단 시작할 때의 배열 입력받기
		for (int r=0; r<12; r++) {
			String str = br.readLine();
			for (int c=0; c<6; c++) {
				board[r][c] = str.charAt(c);
			}
		}

		cycle(true);
		System.out.println(combo);
		
	}
	
	public static void cycle(boolean blow) {
		
		
		// blow가 false인 상태로 다음 사이클이 되었다면 그대로 멈춤!
		while(blow) {
			
			blow=false;
			// board는 변화한상태로 유지되어야함
			// vis는 board가 변화했으니까 초기화
			vis = new boolean[12][6]; 

			for (int r=11; r>=0; r--) {
				for (int c=0; c<6; c++) {
					char color = board[r][c];
					if (color=='.' || vis[r][c]) continue;
					
					// dfs사이클 하나가 시작될 때!!
					queue = new LinkedList<>();
					tmpQueue = new LinkedList<>();
					queue.offer(new RC(r, c));
					vis[r][c] = true;
					if (dfs(color) >= 4) {
						// 터쳐버리기 (알파벳을 .으로 바꾸기?)
						change(tmpQueue);
						blow = true;
					}
					
				}
			}
			
			if (blow) {
				combo++; // combo 하나 늘려주고
				down(); // 터친 것들 다 밑으로 쭉쭉 내려주기 (board update)
			}

		}
		
	}
	
//	public static void print() {
//		for (int r=0; r<12; r++) {
//			for (int c=0; c<6; c++) {
//				System.out.print(board[r][c]);
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------");
//	}
	
	// 터쳐버리는 메서드
	public static void change(Queue<RC> tmpQueue) {
		while (!tmpQueue.isEmpty()) {
			RC tmpRC = tmpQueue.poll();
			board[tmpRC.r][tmpRC.c]='.'; 
		}
	}
	
	// 터진 것들 내려주는 메서드
	public static void down() {
		for (int c=0; c<6; c++) {
			for (int r=11; r>=1; r--) {
				if (board[r][c]=='.') {
					int next=r-1;
					while (next>=0) {
						if (board[next][c]=='.') {
							next-=1;
						} else {
							break;
						}
					}
					
					if (next>=0) {
						board[r][c] = board[next][c];
						board[next][c]='.';
					}
					
				}
			}
		}
		
	}
	
	
	public static int dfs(char color) {
		int cnt=1;

		while (!queue.isEmpty()) {
			RC temp = queue.poll();
			tmpQueue.offer(temp); //4개넘게 이어져있으면 나중에 하나하나 꺼내면서 색칠해야됨
			for (int d=0; d<4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				if (nr>=0 && nr<12 && nc>=0 && nc<6) {
					if (board[nr][nc]==color && !vis[nr][nc]) {
						queue.offer(new RC(nr,nc));
						vis[nr][nc] = true;
						cnt++;
					}
				}
				
			}
		}
		
		return cnt;
	}

}
