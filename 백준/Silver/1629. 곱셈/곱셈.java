import java.io.*;
import java.util.*;

public class Main {

	static int A,B,C;
	
	static long perm(long remainder, long exponent) {
		if (exponent==1) return remainder;
		long tmp = perm(remainder,exponent/2)%C;
		if (exponent%2==0) return (tmp*tmp)%C;
		else return (((tmp*tmp)%C)*remainder)%C;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		long remainder = A%C;
		long result = perm(remainder,B);
		System.out.println(result);
	}
 
}