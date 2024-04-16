import java.io.*;
import java.util.*;

public class Main {

	static int target,newX;
	static int[] originArr,sortedArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		originArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
			int tmp = Integer.parseInt(st.nextToken());
			set.add(tmp);
			originArr[n] = tmp;
		}

		int idx = 0;
		sortedArr = new int[set.size()];
		for (int num : set) {
			sortedArr[idx++] = num;
		}
		Arrays.sort(sortedArr); // 중복없는 배열을 오름차순으로 정렬
		
		// 원본 배열 순서대로 해당 idx의 값이 등장하는 위치를 sortedArr에서 찾고, 그걸 출력하면 개수
		for (int i=0; i<N; i++) {
			target = originArr[i];
			find(0,set.size()-1);
			sb.append(newX).append(" ");
		}

		System.out.println(sb);
	}

	public static void find(int st, int ed) {
		int mid = (st+ed)/2;
		
		if (sortedArr[mid]==target) {
			newX = mid;
			return;
		}
		
		if (sortedArr[mid]<target) {
			find(mid+1,ed);
		} else if (sortedArr[mid]>target) {
			find(st,mid-1);
		}
		
		return;
		
	}
}