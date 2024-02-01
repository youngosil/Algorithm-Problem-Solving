import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		double v = Integer.parseInt(st.nextToken());
		
		int k;
		br.close();
		
		double maybeDays = (v-a)/(a-b);
		if (maybeDays%1==0) {
			k=1;
		} else {
			k=2;
		}
		
		int days = (int) maybeDays;
		bw.write(Integer.toString(days+k));
		bw.close();


	}

}