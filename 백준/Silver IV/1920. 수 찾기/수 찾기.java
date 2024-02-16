import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); //이진탐색쓰려면 정렬되어있어야함요..
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int m=0; m<M; m++) {
			int num = Integer.parseInt(st2.nextToken());
			sb.append(isTrue(num, arr)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 이진탐색알고알고
	static int isTrue(int num, int[] arr) {
		int left = 0; int right = arr.length-1;

		while (right>=left) {
			int mid = (right+left)/2;
			if (num<arr[mid]) {
				right=--mid;
			} else if (num>arr[mid]) {
				left=++mid;
			} else if (num==arr[mid]) {
				return 1;
			}
		}
		
		return 0;
	}

}
