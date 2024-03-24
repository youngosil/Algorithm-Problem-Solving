import java.io.*;
import java.util.*;

public class Solution {

	static int price[],days[],minPrice;
	static List<Integer> list;
	static int matchingMonth[] = {3,1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T  = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			// 3달 이용권 ~ 1일 이용권 순으로 가격 입력받아서 price 배열 완성
			StringTokenizer st = new StringTokenizer(br.readLine());
			price = new int[3]; //초기화
			for (int i=2; i>=0; i--) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			minPrice = Integer.parseInt(st.nextToken()); //최저가 변수 초기화
						
			// 월별 이용일수 배열 완성
			st = new StringTokenizer(br.readLine());
			days = new int[12]; //초기화 
			for (int i=0; i<12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			} 
			
			list = new ArrayList<>();
			recur();
			sb.append(minPrice).append("\n");
		}
		System.out.println(sb);
	}
	
	static int getMonth(List<Integer> list) {
		int sum = 0;
		for (int idx : list) sum += matchingMonth[idx];
		return sum;
	}
	
	static int getPrice(List<Integer> list) {
		int result = 0;
		int start = 0;
		
		for (int idx : list) {
			if (idx == 0) {
				boolean isEmpty = true;
				for (int i=0; i<3; i++) {
					if (days[start+i]!=0) {
						isEmpty=false;
						break;
					}
				}
				if (!isEmpty) result += price[idx];
				start += 3;
			} else if (idx==1) {
				if (days[start]!=0) result += price[idx];
				start += 1;
			} else if (idx==2) {
				if (days[start]!=0) result += days[start]*price[idx];
				start += 1;
			}
		}		
		return result;
	}
	
	
	static void recur() {
		
		int cond = getMonth(list);
		if (cond>=12) {
			if (cond==12) {
//				System.out.println(Arrays.toString(list.toArray()));
				minPrice = Math.min(getPrice(list), minPrice);
			}
			return;
		}

		for (int i=0; i<3; i++) {
			list.add(i);
			recur();
			list.remove(list.size()-1);
		}
		
	}

}
