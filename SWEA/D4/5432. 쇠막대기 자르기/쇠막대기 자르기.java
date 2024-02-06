import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			Stack<Character> stack = new Stack<>();
			Stack<Character> stack2 = new Stack<>();
			String str = br.readLine();
			int sum =0;
			for (int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if (c=='(') {
					stack.push(c);
					
				} else {
					if (stack2.peek()==')') {
						stack.pop();
						sum += 1;
					} else {
						stack.pop();
						sum += stack.size();
					}
				}
				
				stack2.push(c);
			}
			
			bw.write("#"+t+" "+sum+"\n");
			bw.flush();
					
		}
		bw.close();
		br.close();
			
	}

}
