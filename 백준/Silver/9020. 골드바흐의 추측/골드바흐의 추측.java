import java.io.*;
import java.util.*;

public class Main {

	// 소수 판별 함수
	public static boolean isPrime(int num) {
		if (num==2 || num==3) return true;
		if (num%2==0) return false;
		if (num==1) return false;
		int i=1;
		while (num>2*i+1) {
			if (num%(2*i+1)==0) return false;
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int t=0; t<T; t++) {
			int N = sc.nextInt(); // 짝수
			
			int a = N/2;
			int b = N/2;
			
			while (!isPrime(a) || !isPrime(b)) {
				a--;
				b++;
			}
			
			sb.append(a).append(" ").append(b).append("\n");
		}
		System.out.println(sb);

	}

}