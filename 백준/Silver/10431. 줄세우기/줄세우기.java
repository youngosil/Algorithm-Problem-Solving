import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int P = Integer.parseInt(br.readLine());
		
		
		for (int t=1; t<=P; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();
			
			// 테케 번호 입력받고 버리기
			st.nextToken();
			
			int move = 0; //이동 수 저장 변수
			
			// 학생 20명 입력받기
			out : for (int s=0; s<20; s++) {
				// 이전까지의 최대값을 max 변수에 저장
				// 이 값과의 비교를 통해 둘지 앞으로 보낼지 결정
				int num = Integer.parseInt(st.nextToken());
				for (int i=0; i<list.size(); i++) {
					if (list.get(i) > num) {
						move += (list.size()-i);
						list.add(i, num);
						continue out ;
					}
				}
				list.add(num);
			}

			bw.write(t+" "+move+"\n");
			bw.flush();
			
		}
		bw.close();
		br.close();
	}

}