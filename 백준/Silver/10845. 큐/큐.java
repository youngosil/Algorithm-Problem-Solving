import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (queue.size()==0) {
					sb.append("-1\n");
				} else {
					sb.append(queue.poll()+"\n");
				}
				break;
			case "size":
				sb.append(queue.size()+"\n");
				break;
			case "empty":
				if (queue.size()==0) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (queue.size()==0) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peek()+"\n");
				}
				break;
			case "back":
				if (queue.size()==0) {
					sb.append("-1\n");
				} else {
					Queue<Integer> queue2 = new LinkedList<>();
					while (queue.size()!=1) {
						queue2.offer(queue.poll());
					}
					int temp = queue.poll();
					sb.append(temp+"\n");
					queue2.offer(temp);
					while (queue2.size()!=0) {
						queue.offer(queue2.poll());
					}
				}
				break;
			}
		}
		
		System.out.println(sb);
		
		
	}

}
