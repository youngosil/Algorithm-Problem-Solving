import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 일단 배열 완성하기
		Queue<Integer> queue = new LinkedList<>();
		for (int n=1;n<=N;n++) {
			queue.offer(n);
		}
		
		// 어차피 왼쪽으로 도나 오른쪽으로 도나 횟수만 다르지 갱신되는 queue의 형태는 같음.
		// ex) 54321 에서 3을 뽑고 싶을 때 왼쪽으로 돌아도 32154, 오른쪽으로 돌아도 32154
		// 왜냐? 어차피 뺴주려면 맨 앞까지 끌고와야하기 때문 ..
		int num;
		
		int sum=0; //그 수를 다 더해줄 변수
		st = new StringTokenizer(br.readLine());
		for (int m=0; m<M; m++) {
			int cnt=0; //회차마다 2혹은 3이 몇 번 나오는지 계산 (매 회차 갱신되는 임시 변수)
			num = Integer.parseInt(st.nextToken());
			while (queue.peek()!=num) {
				queue.offer(queue.poll()); // 원하는 index가 나올 때까지 poll
				cnt++; //몇 번 옮겼는지도 세줌
			}
			if (cnt > queue.size()/2) {
				sum += queue.size()-cnt; //만약 왼쪽으로 돈 횟수가 오른쪽으로 돌 횟수보다 크다면 오른쪽으로 돌 횟수 더해줌
			} else {
				sum += cnt; //그게 아니면 왼쪽으로 돈 횟수를 추가
			}
			queue.poll();
		}
		
		System.out.println(sum);
	}

}
