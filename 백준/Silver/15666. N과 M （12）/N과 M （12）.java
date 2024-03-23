import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,arr[],temp[];
	static StringBuilder sbAns = new StringBuilder();
	static LinkedHashSet<String> ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[M];
		ans = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		recur(0,0);
		for (String str : ans) {
			sbAns.append(str).append("\n");
		}
		System.out.println(sbAns);
	}
	
	static void recur(int idx, int start) {
		if (idx==M) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<M; i++) {
				sb.append(temp[i]).append(" ");
			}
			ans.add(sb.toString());
			return;
		}
		
		for (int i=start; i<N; i++) {
			temp[idx] = arr[i];
			recur(idx+1,i);
		}
	}
}
