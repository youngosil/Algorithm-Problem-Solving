import java.io.*;
import java.util.*;

public class Main {
	
	static int tc[],arr[],k,tempArr[],tempIdx;
	static StringBuilder sb = new StringBuilder();
	
	static void func(int index) {
		// 기저 조건
		if (index==6) {
			// 출력하고
			for (int num : tempArr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return; //반환
		}
		
		// 재귀 조건
		// tempIdx변수를 통해서 항상 이전 수보다 큰수만 들어가도록 함.
		for (int i=tempIdx; i<k; i++) {
			tempArr[index] = arr[i];
			tempIdx = i+1;
			func(index+1);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken()); // 첫 수가 숫자 개수
			if (k==0) break; //0이면 끝난거
			// 그게 아니라면
			
			arr = new int[k]; // 수들 넣을 집합 (오름차순임)
			tempArr = new int[6]; // 6개의 숫자 넣고 빼고 할 배열 생성
			for (int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			tempIdx=0;
			func(0);
			sb.append("\n");
		}
	
		System.out.println(sb);
	}
}
