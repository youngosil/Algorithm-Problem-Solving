import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ratings = new int[n];
		
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			ratings[i] = num;
		}
		
		Arrays.sort(ratings); // 오름차순 정렬
		
		int exclude = (int) Math.round(n*0.15); //위 아래에서 몇 명 제외 할 지 결정
		double sum = 0;
		for (int i=exclude; i<n-exclude; i++) {
			sum += ratings[i]; // 절삭하고 남은 값들 더해주기
		}
		
		double avg = sum /(n-2*exclude); // 평균 계산
		
		System.out.println(Math.round(avg));
	}

}
