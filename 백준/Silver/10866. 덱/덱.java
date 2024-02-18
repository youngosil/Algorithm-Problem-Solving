import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// deque api를 활용한 풀이 (시간초과 가능성 있음)
		Deque<Integer> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (!deque.isEmpty()) sb.append(deque.removeFirst()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "pop_back":
				if (!deque.isEmpty()) sb.append(deque.removeLast()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if (deque.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if (!deque.isEmpty()) sb.append(deque.peekFirst()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "back":
				if (!deque.isEmpty()) sb.append(deque.peekLast()).append("\n");
				else sb.append(-1).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}
}
