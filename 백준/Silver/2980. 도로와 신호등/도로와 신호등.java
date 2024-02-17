import java.io.*;
import java.util.*;

public class Main {
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int t = 0; // 현재 시간
		int d = 0; // 현재 거리
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken()); // 신호등 위치
			int R = Integer.parseInt(st.nextToken()); // 빨간불 지속시간
			int G = Integer.parseInt(st.nextToken()); // 초록불 지속시간
			
			//신호등에 도착할 때까지 쭉 가다가
			while (d!=D) { 
				d++; t++;
			}
			
			//만약 도착한 시간이 빨간불 상태이라면 대기시간 더해줌
			int remainder = t%(R+G);
			if (remainder<=R) { 
				t += (R-remainder);
			}
		}

		// 신호등 없이 쭉 간 시간 더해줌
		t += (L-d);
		System.out.println(t);
	}

}
