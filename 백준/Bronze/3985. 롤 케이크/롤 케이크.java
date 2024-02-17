import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(br.readLine()); //롤케이크의 길이
		int[] rollcake = new int[L+1]; //1번째조각부터 시작하므로 L+1길이만큼의 롤케이크 배열 생성
		
		// 입력받으면서 조각 수가 최대인 방청객 일단 찾음 (k가 최대)
		// 1차원배열에서 각 n의 수를 센 뒤에
		// 가장 많이 나온 n이 실제로 가장 많이 받은 방청객 수임
		
		int N = Integer.parseInt(br.readLine()); //방청객 수
		int maxExpectation = 0; //최대조각수
		int whoExpectation = 1; //최대조각수 먹을 것으로 기대한 방청객번호
		for (int n=1; n<=N; n++) { // 방청객의 번호도 1번부터 시작 (i>=1)
			// 1. 방청객 정보 일단 받고 max 찾기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); //몇번째조각부터 (단, 조각은 1번째부터 시작)
			int k = Integer.parseInt(st.nextToken()); //몇번째까지
			if ((k-p+1)>maxExpectation) { // 최대조각이 갱신된다면 (같을 경우 앞사람이 출력되어야하므로 등호는 제외)
				maxExpectation = (k-p+1);
				whoExpectation = n; // 방청객 번호 갱신
			}
			
			// 2. 1차원 배열에 값을 입력
			for (int i=p; i<=k; i++) {
				if (rollcake[i]==0) rollcake[i] = n;
			}
		}
		
		int maxReal = 0; //최대조각수
		int whoReal = 1; //실제로 최대조각수 먹을 방청객번호
		int[] cnt = new int[N+1]; //방청객별 조각 수 저장할 배열 선언
		for (int r=1; r<L+1; r++) { //순회하면서 cnt세고 max 갱신하기
			int index = rollcake[r];
			if (index!=0 && ++cnt[index]>maxReal) { //0번은 고려하면 안됨.
				maxReal = cnt[index];
				whoReal = index;
			};
		}

		sb.append(whoExpectation).append("\n").append(whoReal);
		System.out.println(sb);
		
	}

}
 