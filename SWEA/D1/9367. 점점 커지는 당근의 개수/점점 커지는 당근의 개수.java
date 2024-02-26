import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 이 밑으로 구현
			
			int max = 0;
			int cnt = 1;
			
			for (int i = 0; i < N-1; i++) {
				if (arr[i] < arr[i+1]) {
					cnt++;
				} else {
					if (cnt > max) {
						max = cnt;
					}
					cnt = 1;
				}
				if (cnt > max) {
					max = cnt;
				}
			}
			
			// 이 위로 구현
			
			System.out.println("#" + t + " " + max);
		}
	}
}
