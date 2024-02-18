import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = -1;
		
		int N = Integer.parseInt(br.readLine());
				
		for (int i = N/5; i>=0; i--) { // 5kg 최대개수부터 줄여가면서
			if ((N - 5*i)%3 == 0) { // 나머지를 3kg짜리로 채울 수 있다면 거기서 멈추고 (최대값이니까)
				int max3 = (N - 5*i)/3; // 3kg 짜리 개수 계산해서
				result =  max3 + i; // 더한 값이 result
				break;
			}
		}

		System.out.println(result);
	}

}
