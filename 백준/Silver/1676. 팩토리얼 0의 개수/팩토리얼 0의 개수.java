import java.io.*;

public class Main {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cntTwo=0; int cntFive=0;

		for (int i=1; i<=N; i++) {
			int num = i;
			while (num%2==0) {
				num/=2;
				cntTwo++;
			}
			while (num%5==0) {
				num/=5;
				cntFive++;
			}
		}
		
		int result = Math.min(cntTwo, cntFive);
		System.out.println(result);
	}

}
