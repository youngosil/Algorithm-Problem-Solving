import java.io.*;
import java.util.*;

class Pair implements Comparable {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Object o) {
		Pair p = (Pair) o;
		if (p.y == this.y) { // y좌표가 같으면 x좌표 오름차순 (기준 2)
			return this.x - p.x;
		}
		return this.y - p.y; // 다르면 y좌표 오름차순 (기준 1)
	}
	
	@Override
	public String toString() { // 출력 구조 정의
		return x+" "+y;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		
		for (int n=0; n<N; n++) { // x,y 순서쌍 입력받고
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pairs[n] = new Pair(x,y);
		}
		
		Arrays.sort(pairs); // 기준에 따라 정렬 후
		
		for (Pair p : pairs) { // 차례대로 출력
			sb.append(p.toString()).append("\n");
		}
		
		System.out.println(sb);
	}

}
