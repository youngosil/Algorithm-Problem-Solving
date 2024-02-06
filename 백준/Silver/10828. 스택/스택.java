import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //명령의 수 입력받기
		Stack<Integer> stack = new Stack<>(); // 스택 생성
		
		for (int n=0; n<N; n++) { //명령의 수 동안 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (command.equals("pop")) {
				if (stack.size()!=0) {
					int num = stack.pop();
					bw.write(num+"\n");
				} else bw.write("-1\n");
				bw.flush();
			} else if (command.equals("size")) {
				bw.write(stack.size()+"\n");
				bw.flush();
			} else if (command.equals("empty")) {
				if (stack.isEmpty()) {
					bw.write("1\n");
				} else bw.write("0\n");
				bw.flush();
			} else if (command.equals("top")) {
				if (stack.size()!=0) {
					int num = stack.peek();
					bw.write(num+"\n");
				} else bw.write("-1\n");
				bw.flush();
			}
		}
	}

}