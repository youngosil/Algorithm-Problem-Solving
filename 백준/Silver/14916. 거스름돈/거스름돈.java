import java.io.*;
import java.util.*;

public class Main {

	static int[] dp;
	
	static int getCnt(int money) {
		if (money<0 || dp[money]==Integer.MAX_VALUE)return Integer.MAX_VALUE;
		return dp[money]+1;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dp = new int[N+1];
		
		for (int n=1; n<=N; n++) {
			dp[n] = Math.min(getCnt(n-2),getCnt(n-5));
		}
		
		// 불가능하면 -1 출력
		if (dp[N]==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N]);
		
	}

}
