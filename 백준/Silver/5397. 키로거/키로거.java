import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
    	//입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스만큼 반복 출력
        for (int t=1; t<=T; t++) {
        	String str = br.readLine();
        	Stack<Character> stack = new Stack<>();
        	Stack<Character> temp = new Stack<>();

        	for (int i=0; i<str.length(); i++) {
            	char c = str.charAt(i);
            	if (c=='<') {
            		if (stack.size()>0) { //커서 앞의 데이터를 우선 임시 stack으로 빼둔다 = 커서를 앞으로 이동
                		temp.add(stack.pop());
            		}
            	} else if (c=='>') { //커서 뒤의 데이터를 temp stack에서 하나 빼서 합쳐준다
            		if (temp.size()>0) {
            			stack.add(temp.pop());
            		}
            	} else if (c=='-') { //커서 앞의 데이터를 하나 날려준다
            		if (stack.size()>0) {
            			stack.pop();
            		}
            	} else { // 그게 모두 아니라면 stack에 정상적으로 쌓아준다
            		stack.add(c);
            	}
        	}
        	// 테케 
        	// asdkuh<h<<45>sQ-rt-
        	// 배열 내의 데이터들을 문자열로 결합하여 출력
        	for (int i=0; i<stack.size(); i++) {
        		bw.write(stack.get(i));
        	}
        	
        	while (temp.size()>0) {
        		bw.write(temp.pop());
        	}
        	
        	bw.write("\n");
        	bw.flush();
        }
        bw.close();
        br.close();
        
    }
}