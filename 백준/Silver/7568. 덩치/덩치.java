import java.io.*;
import java.util.*;

public class Main {
	
	// body 객체 생성
	static class Body {
		int weight;
		int height;
		
		Body(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Body[] bodies = new Body[N]; // Body 객체 담을 배열 생성
		
		for (int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			bodies[n] = new Body(weight,height); // 몸무게와 키 입력받고 body 객체를 배열에 넣기
		}
		
		for (int n=0; n<N; n++) { // 반복문 순회하면서 
			int cnt=1; // 일단 자기 자신을 cnt
			for (int i=0; i<N; i++) { // 자신이 아닌 다른 Body 객체와 비교하면서
				if (i!=n) { 
					if (bodies[n].height < bodies[i].height
							&& bodies[n].weight < bodies[i].weight) {
						cnt++; // 몸무게와 키 모두 큰 원소의 개수를 더한 것을 등수로 함 (ex. 위에 3명 있음 => 본인 등수 = 1+3 = 4등)
					}
				}
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}

}
