import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		String str = br.readLine();
		
		for (int i=0; i<str.length(); i++) { //일단 입력값을 stack에 넣기
			stack.push(str.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			String command = br.readLine();
			char ch = command.charAt(0);
			if (ch=='L') {
				if (stack.size()!=0) stack2.push(stack.pop()); //stack이 비어있지 않으면 하나 빼서 queue로 이동 -> 커서왼쪽으로
			} else if (ch=='D') {
				if (stack2.size()!=0) stack.push(stack2.pop()); //queue이 비어있지 않으면 하나 빼서 stack으로 이동 -> 커서오른쪽으로
			} else if (ch=='B') {
				if (stack.size()!=0) stack.pop(); //날려버려
			} else if (ch=='P'){
				char newChar = command.charAt(2);
				stack.push(newChar); //입력해버려
			}
		}
		
		while (stack2.size()!=0) {
			stack.push(stack2.pop()); //남은 거 다 붙여버려
		} 
		
		Stack<Character> result = new Stack<>(); // 결과 출력하려면 한글자씩 해야하는데 stack에서 빼내면 거꾸로 나오니까 거꾸로 stack을 하나 더 만듦
		while (stack.size()!=0) {
			result.push(stack.pop());
		}
		
		while (result.size()!=0) { //결과출력
			bw.write(result.pop());
		}
		
		bw.close();
		br.close();
		
	}

}