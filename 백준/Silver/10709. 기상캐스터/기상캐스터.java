import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); // Rows
		int W = Integer.parseInt(st.nextToken()); // Cols
		
		// 구름 여부 입력받기
		char[][] weather = new char[H][W];
		for (int r=0; r<H; r++) {
			String str = br.readLine();
			for (int c=0; c<W; c++) {
				weather[r][c]=str.charAt(c);
			}
		}
		
		// 1. 왼쪽에 있는 가장 가까운 c를 찾고, 그 c와 본인과의 차이를 출력
		// 2. 본인이 c라면 0출력, 왼쪽에 아예 c가 없으면 -1출력
		for (int r=0; r<H; r++) {
			out : for (int c=0; c<W; c++) {
				int i=0; // 본인의 위치와의 차이 (몇 칸)
				int nc = c-i; // 살펴볼 왼쪽 칸
				while (nc>=0) { //배열의 범위 내에 있다면
					if (weather[r][nc]=='c') { // 왼쪽으로 i칸 간 곳에 c가 있다면 출력하고 다음으로 넘어간
						sb.append(i).append(" ");
						continue out;
					}
					i++; // 만약 아니라면 왼쪽으로 한 칸씩 더 이동하면서 살핌
					nc = c-i;
				}
				//왼쪽 끝까지 갔는데도 구름이 없을 경우 -1출력
				sb.append(-1).append(" ");
				
			}
			// 한 행이 다 끝나고 다음 행으로 넘어갈 때는 한 줄 넘어서 출력
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
