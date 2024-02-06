import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 수열의 크기 입력받기
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt =0;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (arr[i] + arr[j] == x) {
					cnt++;
					break;
				}
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.close();
		br.close();
	}
}