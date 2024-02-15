import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		for (int n=1; n<=N; n++) {
			queue.offer(n);
		}

		while(queue.size()!=1) {
			if (++cnt%K==0) sb.append(queue.poll()).append(", ");
			else queue.offer(queue.poll());
		}
		
		sb.append(queue.poll()).append(">");
		System.out.println(sb.toString());
		
	}

}
