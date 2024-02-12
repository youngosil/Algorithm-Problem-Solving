import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테케 4개
		for (int tc=1; tc<=4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] x = new int[4];
			int[] y = new int[4];
			
			for (int i=0; i<8; i++) {
				if (i%2==0) {
					x[i/2] = Integer.parseInt(st.nextToken());
				} else {
					y[(i-1)/2] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 닿지 않는 경우 -> 점이 닿는 경우 -> 선분이 닿는 경우 -> 면적이 겹치는 경우
			if (x[2]>x[1] || x[3]<x[0] || y[2]>y[1] || y[3]<y[0]) {
				bw.write("d\n");
			} else if (x[0]==x[3] && y[0]==y[3]
					|| x[1]==x[2] && y[0]==y[3]
					|| x[0]==x[3] && y[1]==y[2]
					|| x[1]==x[2] && y[1]==y[2]) {
				bw.write("c\n");
			} else if (x[0]==x[3]
					|| x[1]==x[2]
					|| y[0]==y[3]
					|| y[1]==y[2]) {
				bw.write("b\n");
			} else {
				bw.write("a\n");
			}
		}
		
		bw.close();
		br.close();
		
	}

}
