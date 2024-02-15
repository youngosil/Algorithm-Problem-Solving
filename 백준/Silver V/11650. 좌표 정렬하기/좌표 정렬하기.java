import java.util.*;
import java.io.*;

class Coor implements Comparable{
	
	int x; int y;
	
	Coor(){}
	Coor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Object o) {
		Coor coor = (Coor) o;
		if (coor.x==this.x) return this.y-coor.y;
		return this.x-coor.x;
	}
	
	@Override
	public String toString() {
		return x+" "+y+"\n";
	}
}


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int x; int y;
		
		int N = Integer.parseInt(br.readLine());
		Coor[] coors = new Coor[N]; // 좌표 객체 담을 배열 생성
		
		// 배열에 좌표 객체 담기
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			coors[n] = new Coor(x,y);
		}
		
		Arrays.sort(coors);
		
		// 기준에 따라 출력
		for (Coor c : coors) {
			sb.append(c.toString());
		}
		
		System.out.println(sb.toString());
	}
}
