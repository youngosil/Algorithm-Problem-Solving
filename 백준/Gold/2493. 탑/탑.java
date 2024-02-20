import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> columns = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int n=0; n<N; n++) {
			int num = Integer.parseInt(st.nextToken());

			// 이전의 수가 더 작다면 뛰어 넘으니까 빼버림
			while (!columns.isEmpty() && columns.peek() < num) {
				if (columns.size() == index.size()) { // 근데 계속 돌다가 그 수가 전고점일 경우에는
					index.pop(); // index에 입력되어있으니까 같이 빼줌
				}
				columns.pop();
			}
			
			// 비어있으면 두 스택에 각각 기둥의 높이와 그 기둥의 index를 입력
			if (columns.isEmpty()) {
				sb.append(0).append(" ");
			} else if (columns.peek() > num) {
				sb.append(index.peek()).append(" "); // 만약 이전의 수가 새로 들어온 수보다 크다면 이전 기둥에 막히니까 출력
			}
			
			columns.push(num);
			index.push(n+1);

		}

		System.out.println(sb);
	}

}
