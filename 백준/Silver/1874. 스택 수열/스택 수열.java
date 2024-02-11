import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N]; //만들어야하는 수열을 나타내는 배열에 수열 담기
		for (int n=0; n<N; n++) {
			nums[n]=Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>(); // 수를 뺐다가 넣을 때 사용할 임시 stack 선언
		int index=0; int tempNum=0; //index=0~N-1, tempNum=1~N
		StringBuilder result = new StringBuilder();
		
		while (index<N && tempNum<=N) {
			// stack이 비어있거나, 가장 마지막의 수가 수열과 일치하지 않을 경우에는 push
			if (stack.size()==0 || stack.peek()!=nums[index]) {
				stack.push(++tempNum);
				result.append("+\n");
			// 수열의 수와 일치할 때는 pop 해주고, 수열의 다음 인덱스로 넘어감.
			} else {
				stack.pop();
				result.append("-\n");
				index++;
			}
		}
		
		if (stack.size()==0) {
			bw.write(result.toString());
		} else {
			bw.write("NO\n"); //이미 수는 다 제공되었는데 수열이 완성되지 않은 경우 NO 출력
		}
		
		bw.close();
		br.close();
		
	}

}
