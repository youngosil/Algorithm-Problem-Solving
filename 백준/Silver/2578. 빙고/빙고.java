import java.io.*;
import java.util.*;

public class Main {

	// 빙고 개수 확인하는 함수 생성
	public static int isBingo(int[][] bingo) {
		int lines=2;
		// 가로 탐색
		out1 : for (int r=0; r<5; r++) {
			for (int c=0; c<5; c++) {
				if (bingo[r][c]!=0) {
					continue out1;
				}
			}
			lines++;
		}
		
		// 세로 탐색
		out2 : for (int c=0; c<5; c++) {
			for (int r=0; r<5; r++) {
				if (bingo[r][c]!=0) {
					continue out2;
				}
			}
			lines++;
		}
		
		// 대각선 탐색 (우하강, 우상향)
		for (int i=0; i<5; i++) {
			if (bingo[i][i]!=0) {
				lines--;
				break;
			}
		}
		
		for (int i=0; i<5; i++) {
			if (bingo[i][4-i]!=0) {
				lines--;
				break;
			}
		}
		
		return lines;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 일단 빙고판 그리기 (2차원 배열)
		// 2. 사회자가 숫자 부를때마다 해당 칸의 숫자를 0으로 바꿔줌
		// 3. 그리고 나서 가로, 세로, 대각선을 탐색하면서 00000인 줄이 몇 개 있는지 확인
		// 4. 최소 13개의 숫자를 불러야 3줄이 완성되므로 탐색은 그 이후부터 시작하면됨 (?)
		
		int[][] bingo = new int[5][5];
		for (int r=0; r<5; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<5; c++) {
				bingo[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		
		int[] nums = new int[25]; //사회자가 부르는 숫자 담을 배열 생성
		for (int a=0; a<5; a++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int b=0; b<5; b++) {
				nums[a*5+b] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int cnt=0;
		out : for (int i=1; i<25; i++) {
			cnt++;
			int num = nums[i-1]; // 사회자가 부르는 수
			
			// 사회자가 부르는 칸의 숫자를 0으로 바꿔주기
			for (int r=0; r<5; r++) {
				for (int c=0; c<5; c++) {
					if (bingo[r][c]==num) { 
						bingo[r][c] = 0;
					}
				}
			}
				
			if (isBingo(bingo)>=3) {
				break out;
			}
		}
		
		
		System.out.println(cnt);
	}

}
