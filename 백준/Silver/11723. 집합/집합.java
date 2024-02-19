import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		boolean[] nums = new boolean[21]; // 1~21까지의 원소 유무를 알 수 있는 배열을 생성
		int N = Integer.parseInt(br.readLine());
		int x =0;
		
		
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				nums[x] = true;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				nums[x] = false;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if (nums[x]==true) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if (nums[x]==true) nums[x] = false;
				else nums[x] = true;
				break;
			case "all": // 1~20까지 존재하는 걸로 바꿈
				for (int i=1; i<21; i++) {
					nums[i] = true;
				}
				break;
			case "empty":
				nums = new boolean[21]; //배열 초기화
				break;
			}
		}

		System.out.println(sb);
	}

}
