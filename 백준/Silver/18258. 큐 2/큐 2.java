import java.io.*;
import java.util.*;

public class Main {
	
	static int[] queue = new int[2000000];
	static int front = -1; 
	static int rear = -1;
	
	public static void push(int data) {
		queue[++rear] = data;
	}
	
	public static int pop() {
		if (isEmpty()==1) return -1;
		return queue[++front];
	}
	
	public static int size() {
		return rear-front;
	}
	
	public static int isEmpty() {
		if (front==rear) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (isEmpty()==1) return -1;
		return queue[front+1];
	}
	
	public static int back() {
		if (isEmpty()==1) return -1;
		return queue[rear];
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String command;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			switch (command) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			case "empty":
				sb.append(isEmpty()).append("\n");
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
