import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int ed,w;
	
	Node(int ed,int w) {
		this.ed = ed;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.w-o.w;
	}
	
	@Override
	public String toString() {
		return "<"+ed+", "+w+">";
	}
}


public class Main {

	static int N,M,sum,minus;
	static boolean vis[];
	static StringTokenizer st;
	static PriorityQueue<Node> pq;
	static List<Node>[] nodes;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //정점(집)의 수
			M = Integer.parseInt(st.nextToken()); // 간선(길)의 수
			
			if (N==0 && M==0) break;
			
			// 빈 인접리스트 생성
			nodes = new ArrayList[N]; // 0번부터 시작
			for (int i=0; i<N; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			// 인접리스트 배열에 값 입력
			sum = 0; // 원래 가중치 전부 더한 결과 계산할 변수
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				sum += weight;
				
				// 무향이니까 두번씩 추가
				nodes[start].add(new Node(end,weight));
				nodes[end].add(new Node(start,weight));
			}
			
			// 0번부터 시작
			pq = new PriorityQueue<>();
			vis = new boolean[N]; // 0번부터 시작
			
			vis[0] = true;
			for (Node n : nodes[0]) {
				pq.offer(n);
			}
			
			minus = 0; // 절약 해서 결국 최소값이 얼마일지 계산하는 변수
			while (!pq.isEmpty()) {
				Node curr = pq.poll();
				if (vis[curr.ed]) continue; // 도착 정점을 이미 방문했다면 패스
				
				// 그게 아니라면
				vis[curr.ed]=true; // 방문체크해주고
				minus += curr.w; // 이 정점까지의 길 유지비 더해줌
				
				// 이제 도착정점을 시작정점으로 치환
				// 이 시작정점 연결리스트에 들어있는 애들 순회하면서
				for (Node n : nodes[curr.ed]) {
					if (!vis[n.ed]) pq.offer(n); // 도착정점이 방문한적 없는애들이면 pq에 넣음
				}
			}
			
			sb.append(sum-minus).append("\n");
			
		}
		
		System.out.println(sb);

	}

}