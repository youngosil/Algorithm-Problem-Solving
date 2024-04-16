import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	static int N;
	static long[] arr;
	static Map<Long, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 최빈값 구하기
		// 우선 배열에 데이터 넣기
		for (int i = 0; i < N; i++) {
			Long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0)+1); //
		}
		
		// value의 최댓값과, key의 최솟값 선언 및 할당
		int max = Integer.MIN_VALUE;
		long key = Long.MAX_VALUE;
		
		for (Entry<Long, Integer> entry : map.entrySet()) {
			if (entry.getValue()>max) { // 최빈값 등장 시 key와 max를 갱신
				max = entry.getValue();
				key = entry.getKey();
			} else if (entry.getValue()==max && entry.getKey()<key) { // 같을 경우 key가 더 작다면 갱신
				key = entry.getKey(); 
			}
		}
		
		System.out.println(key);

	}
}
