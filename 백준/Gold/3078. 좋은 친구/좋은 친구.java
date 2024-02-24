import java.io.*;
import java.util.*;

class Student implements Comparable { // 길이가 큰 순서대로 비교기준 설정
	int idx;
	int len;
	
	Student(int idx, int len) {
		this.idx = idx;
		this.len = len;
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		if (this.len==s.len) return  this.idx-s.idx; // 동일한 len이면 idx 오름차순 (등수 높은 순서대로)
		return this.len-s.len; // len기준 오름차순 정렬
	}
}

public class Main {

	static int N,K;
	static long goodFriendsCnt;
	static PriorityQueue<Student> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 N
		K = Integer.parseInt(st.nextToken()); // 등수 차이 K 
		
		// 성적순으로 반 학생의 이름이 주어짐
		Student[] arr = new Student[N];
		for (int idx=0; idx<N; idx++) {
			int len = br.readLine().length();
			arr[idx] = new Student(idx, len); //idx와 이름의 길이를 인자로 하는 Student객체를 배열에 우선 담음
		}
		
		Arrays.sort(arr); // 이름길이, 등수 모두 오름차순으로 정렬
		
		Queue<Student> queue = new LinkedList<>();
		for (int i=0; i<N; i++) {
			while (true) {
				if (queue.isEmpty()) {
					queue.add(arr[i]);
					break;
				} else if (arr[i].len == queue.peek().len && arr[i].idx - queue.peek().idx <= K ) {
					goodFriendsCnt += queue.size(); // 넣기 전 처음부터 마지막까지 넣을 Student의 좋은 친구라는 거니까 전체 +
					queue.add(arr[i]); // 그 다음 넣어주기
					break;
				} else { // 좋은 친구가 아니면 다른 조건에 걸릴 때까지 빼버림
					queue.poll();
				}
			}
		}
		
		System.out.println(goodFriendsCnt);
	}
	

}
