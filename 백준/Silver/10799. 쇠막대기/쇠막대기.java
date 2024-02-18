import java.io.*;
import java.util.*;
	
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String steelBars = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int cnt = 0; // 잘린 막대기 개수 변수
		char temp = '(';
		
		// 괄호 입력받으면서 잘린 막대기 세기
		for (int i=0; i<steelBars.length(); i++) {
			char ch = steelBars.charAt(i);
			
			if (ch=='(') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
					if (temp==')') { // 만약 직전에도 )가 있었으면 레이저가 아니고 막대기의 끝이라는 뜻이기 때문에 1만 추가
						cnt++;
					} else {
						cnt += stack.size(); 
					}
					
				}
			}
			
			temp = ch; //직전 char를 현재 입력받은 char로 갱신하고 다음 걸로 넘어갈 수 있게 함
			
		}
		
		System.out.println(cnt);
	}

}
