import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 개수 cnt할 map 생성
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력받은 값들을 map에 넣고 수정
		for (int n=0; n<N; n++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num,map.getOrDefault(num, 0)+1); //이미 map에 있으면 +1하고 없으면 넣고 +1
		}
		
		// 개수를 확인할 숫자들 입력받고 map에서 추출
		// 이 때, 값이 없으면 0이 출력되도록 getOrDefault 메소드를 사용
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2= new StringTokenizer(br.readLine());
		
		for (int m=0; m<M; m++) {
			int key = Integer.parseInt(st2.nextToken());
			int value = map.getOrDefault(key,0);
			sb.append(value).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
