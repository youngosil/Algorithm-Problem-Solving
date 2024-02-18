import java.io.*;
import java.util.*;

public class Main {

	static class Col implements Comparable {
		int loc;
		int height;
		
		Col(){}
		Col(int loc, int height){
			this.loc = loc;
			this.height = height;
		}
		
		@Override
		public int compareTo(Object o) { // 높이 기준 내림차순으로 정렬
			Col col = (Col) o;
			return col.height - this.height;
		}
		@Override
		public String toString() {
			return "Col [loc=" + loc + ", height=" + height + "]";
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L, H;
		// 사용하면서 최대값, 그다음 최대값, 그다음 최대값으로 쭉쭉 내려가면서 지붕 완성
		// 가장 큰 최대값을 기준으로 그다음은 왼쪽, 오른쪽 한방향씩만 비교
		// 처음과 마지막 높이에 무조건 닿도록함
		
		int N = Integer.parseInt(br.readLine()); // 기둥의 개수
		Col[] arr = new Col[N];
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr[n] = new Col(L,H);
		}
		
		Arrays.sort(arr); // 높이 기준 내림차순 정렬
		
//		for (Col c : arr) {
//			System.out.println(c.toString());
//		}
		
		// 가장 높은 기둥으로 초기화
		int right = arr[0].loc;
		int left = arr[0].loc;
		int area = arr[0].height; // 높은 기둥 면적 먼저 더해줌
		
		for (int i=1; i<N; i++) {
			int l = arr[i].loc;
			int h = arr[i].height;
			// 우측 max 찾기
			if (l>right) {
				area += (l-right)*h; //면적 더해주고
				right = l; //right 변수를 더 오른쪽으로 바꿔줌 (기존 right와 현재 right 사이에 있는 작은 값들은 무시해야하기 때문)
			} else if (l<left) { // 좌측 max 찾기
				area += (left-l)*h; //면적 더해주고
				left = l;
			}
			
			// 둘 다 아니라면 넘어가야함 (오목한 부분 있으면 안되니까)
			
		}
		
		System.out.println(area);
	}
	
}