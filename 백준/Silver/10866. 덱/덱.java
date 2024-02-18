import java.io.*;
import java.util.*;

public class Main {

	static int mx = 10000;
	static int head, tail;
	static int[] deque = new int[2*mx+1];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; String command; StringBuilder sb = new StringBuilder();
		
		head = mx; // 가장 앞에 있는 원소의 index
		tail = mx; // 가장 뒤에 있는 원소의 index + 1

		int N = Integer.parseInt(br.readLine());
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			switch (command) {
			case "push_back":
				pushBack(Integer.parseInt(st.nextToken()));
				break;
			case "push_front":
				pushFront(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				sb.append(popFront()).append("\n");
				break;
			case "pop_back":
				sb.append(popBack()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				if (head==tail) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
			 
			
		}
		 
		System.out.println(sb.toString());
		
	}

	static void pushFront(int X) {
		deque[--head] = X;
	}
	
	static void pushBack(int X) {
		deque[tail++] = X;
	}
	
	static int popFront() {
		if (head!=tail) {
			return deque[head++];
		}
		else return -1;
	}
	
	static int popBack() {
		if (head!=tail) {
			return deque[--tail];
		}
		else return -1;
	}
	
	static int size() {
		if (head==tail) {
			return 0;
		}
		return tail-head;
	}
	static int front() {
		if (head!=tail) {
			return deque[head];
		}
		else return -1;
	}
	
	static int back() {
		if (head!=tail) {
			return deque[tail-1];
		}
		else return -1;
	}
	
}
