import java.io.*;
import java.util.*;

class Couple {
	int x,y;
	
	Couple(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	
	static int N,M,min,start;
	static List<Couple> houses,stores;
	static Couple[] mGroup;
	
	// 두 좌표 간 거리 계산해서 반환하는 함수
	static int calcDist(Couple a, Couple b) {
		int dist = 0;
		dist += Math.abs(a.x-b.x);
		dist += Math.abs(a.y-b.y);
		return dist;
	}
	
	// 각 치킨집 set별 최소 거리 계산해서 반환하는 함수
	static int calcMin(List<Couple> houses, Couple[] mGroup) {
		int sum = 0;
		
		for (int i=0; i<houses.size(); i++) {
			// 각 집별 유효 치키집과의 가장 짧은 거리 계산할 변수 초기화
			int minDist = Integer.MAX_VALUE;
			for (int j=0; j<mGroup.length; j++) {
				// 모든 치킨집과의 거리를 계산 및 최소값 갱신
				minDist = Math.min(minDist, calcDist(houses.get(i), mGroup[j]));
			}
			sum += minDist; //매 집마다 치킨집과의 가장 짧은 거리를 더해줌
		}
		return sum;
	}
	
	public static void recur(int idx) {		
		// 기저 조건
		if (idx==M) {
			int tempMin = calcMin(houses,mGroup);
			min = Math.min(tempMin,min);
			return;
		}
		
		// 재귀 조건
		for (int i=start; i<stores.size(); i++) {
			mGroup[idx] =  stores.get(i);
			start = i+1;
			recur(idx+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		houses = new ArrayList<>();
		stores = new ArrayList<>();
		mGroup = new Couple[M]; //M개 치킨집 넣고 뺴고 할 배열 생성
		
		// 쭉 돌면서 치킨집 좌표는 치킨집 리스트로, 집 좌표는 집 리스트로 넣어줌
		for (int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=1; c<=N; c++) {
				int kind = Integer.parseInt(st.nextToken());
				if (kind==1) houses.add(new Couple(r,c));
				else if (kind==2) stores.add(new Couple(r,c));
			}
		}
		
		// m개를 뽑으면서 min 갱신
		start = 0;
		recur(0);
		System.out.println(min);
	}

}
