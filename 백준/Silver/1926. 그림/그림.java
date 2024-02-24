import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean[][] vis = new boolean[R][C]; //방문 여부를 기재할 2차원 배열 선언
		int[][] pic = new int[R][C]; //그림 그릴 배열 선언
		
		// 일단 그림 입력 받기
		for (int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<C; c++) {
				pic[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int r=0; r<R; r++) {
//			for (int c=0; c<C; c++) {
//				System.out.print(pic[r][c]+" ");
//			}
//			System.out.println();
//		}
		
		// 상하좌우 delta 배열
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		// 처음부터 돌면서 최대 너비 탐색
		Queue<Integer[]> queue = new LinkedList<>();
		Integer[] coor;
		int maxCnt=0; // 면적의 최대값을 저장할 변수(그림이 하나도 없으면 0을 출력해야함..)
		int cnt = 0; // 그림마다 색칠된 면적을 계산할 변수
		int cntPic = 0; //그림의 개수 셀 변수

		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				if (vis[r][c]) continue; //이미 방문한 곳이면 pass
				if (pic[r][c] == 1) { //방문하지 않았고, 만약 그림에 색칠된 곳이라면 그곳을 기점으로 탐색 시작
					
					cnt = 1; //새로운 윈도우에서 너비 구해줄거니까 1으로 초기화(색칠된 자기자신 포함), 나중에 최대인지 확인하면서 갱신
					cntPic++;
					
					// 1. 일단 탐색을 시작할 첫 번째 원소부터 방문 체크 해주고 queue에 넣음
					vis[r][c] = true; // 방문했다고 표시
					coor = new Integer[] {r,c}; //순서쌍 객체 만들기
					queue.offer(coor); //queue배열에 방문하고 조건에 맞는 순서쌍 객체를 넣음
					
//					System.out.print("r : "+r+" c : "+c);
					
					// 2. queue가 빌 때까지 다음의 과정을 반복 (끝나면 다음 턴으로 넘어감 ㅋㅋ)
					while (!queue.isEmpty()) {
						// 맨 앞의 것을 queue에서 제거하고
						Integer[] tmp = queue.poll();
						int tempR = tmp[0];
						int tempC = tmp[1];
						// 상하좌우 탐색 시작 ..
						for (int d=0; d<4; d++) {
							int nr = tempR + dr[d];
							int nc = tempC + dc[d];
							
							if (nr<0 || nr>=R || nc<0 || nc>=C) continue; // 배열 범위 벗어나면 pass
							if (pic[nr][nc]==1 && !vis[nr][nc]) { //색칠되어 있으면서 방문한 적이 없으면
								coor = new Integer[] {nr,nc}; //순서쌍 객체 만들기
								queue.offer(coor); //queue배열에 방문하고 조건에 맞는 순서쌍 객체를 넣음
								cnt++; //너비도 ++해줌
							}
							vis[nr][nc] = true; // 방문했다고 표시 (1이든 0이든 둘 다 해야함)
						}
					}
					
					// 3. maxCnt 갱신 + 만약 queue가 비었다면 다음 턴으로 넘어감 (시작점 찾아 삼만리)
					maxCnt = Math.max(maxCnt, cnt);
//					System.out.println("/ cnt : "+cnt+" macCnt : "+maxCnt);
				}
			}
		}
		System.out.println(cntPic); //그림 개수
		System.out.println(maxCnt); //그림별 최대 면적
	}

}
