import java.io.*;
import java.util.*;

public class Main {

	static boolean[] prime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		makePrime(M,N);
		
		// 소수만 출력
		for (int i=M; i<=N; i++) {
			if (prime[i]==false) { //소수이면 false, 아니면 true
				sb.append(i).append("\n"); // 소수일경우 출력
			}
		}
		
		System.out.println(sb);
	}
	
	// 소수 출력 함수
	static void makePrime(int M, int N) {
		prime = new boolean[N+1]; //0~N
		
		prime[0] = prime[1] = true; //0번 인덱스는 버리는거고, 1은 소수가 아님
		
		for (int i=2; i<=Math.sqrt(N); i++) { //2부터 시작해서 차례대로 배수 다 칠해버려
			if (prime[i]==true) continue;
			for (int j=i*i; j<prime.length; j=j+i) {
				prime[j]=true;
			}
		}
	}

}
