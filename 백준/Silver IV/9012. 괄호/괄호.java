import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack; 
		out : for (int t=0; t<T; t++) {
			String str = br.readLine();
			stack = new Stack<>(); //각 줄별로 결과 출력해야하므로 stack 초기화
			for (int i=0; i<str.length(); i++) {
				char temp = str.charAt(i);
				if (temp=='(') {
					stack.push(temp);
				} else {
					if (stack.size()==0) {
						sb.append("NO").append("\n");
						continue out;
					}
					stack.pop();
				}
			}
			
			if (stack.size()!=0) sb.append("NO").append("\n");
			else sb.append("YES").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
