import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,arr[],temp[];
	static List<String> list = new ArrayList<>(); //이미 등장한 배열을 담을 str list (길이를 알 수 없으니 arraylist로 함)
	static boolean vis[];
	static LinkedHashSet<String> ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		vis = new boolean[N];
		 
		M = Integer.parseInt(st.nextToken());
		temp = new int[M];
		
		// 배열을 String으로 저장할 집합 (중복 없애야하므로)
		ans = new LinkedHashSet<>();
		
		// 일단 주어진 배열을 입력받는다.
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 사전순으로 출력해야 하니 배열을 오름차순 정렬
		Arrays.sort(arr);
		
		// 재귀 함수 수행
		recur(0);
		
		// 출력
		for (String arr : ans) {
			System.out.println(arr);
		}
		
	}

	public static void recur(int idx) {
		if (idx==M) { // 개수 꽉차면
			
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<M; i++) { // 출력 배열을 str으로 바꿔서
				sb.append(temp[i]+" ");
			}
			ans.add(sb.toString()); // ans 집합에 넣음
			
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!vis[i]) {
				temp[idx] = arr[i];
				vis[i] = true;
				recur(idx+1);
				vis[i] = false;
			}
		}
	}
}
