import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[N+1][K+1];

		for (int n=0; n<=N; n++) {
			dp[n][0] = 1; 
		}
		
		for (int n=1; n<=N; n++) {
			for (int k=1; k<=K; k++) {
				dp[n][k] = (dp[n-1][k]+ dp[n-1][k-1])%10007;
			}
		}

		System.out.println(dp[N][K]);
		
	}

}