import java.io.*;
import java.util.*;

public class Solution {
	
	static List<ArrayList<Integer>> magnets; //자석 담을 배열
	static int[] dx = {-1,1};
	
	// 최종적으로 점수 계산하는 함수
	public static int score() {
		int sum = 0;
		if (magnets.get(0).get(0)==1) sum+=1;
		if (magnets.get(1).get(0)==1) sum+=2;
		if (magnets.get(2).get(0)==1) sum+=4;
		if (magnets.get(3).get(0)==1) sum+=8;
		return sum;
	}
	
	public static void move(int direction, ArrayList<Integer> magnet) {
		// direction이 0이면 (arrays 초기화된대로 되어있으면 바꾸지 X)
		if (direction==1) { // 시계방향 회전 (맨 뒤꺼 배서 맨 앞으로 넣음)
			int tmp = magnet.get(7);
			magnet.remove(7);
			magnet.add(0, tmp);
		} else if (direction==-1){ // 반시계방향 회전 (맨 앞꺼 빼서 맨 뒤로 넣음)
			int tmp = magnet.get(0);
			magnet.remove(0);
			magnet.add(tmp);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			magnets = new ArrayList<>();
			
			// 현재 magnets가 비어있으므로 arraylist 총 4개 먼저 생성해줘야함 (이거 안하면 indexoutof 어쩌구 남 ;;)
			for (int i = 0; i < 4; i++) {
                magnets.add(new ArrayList<Integer>());
            }
			
			// 자석 4개 (각 자석당 날 8개) 자성 정보 입력받기
			// N극이 0, S극이 1, 맨위부터 시계방향으로 주어짐
			for (int r=0; r<4; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<8;c++) {
					magnets.get(r).add(c,Integer.parseInt(st.nextToken()));
				}
			}
			
			// 자석 1칸 회전시키는 회전정보 (자석번호, 회전방향)
			// 1이면 시계방향(오른쪽), -1이면 반시계방향(왼쪽)
			for (int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int magnetNum = Integer.parseInt(st.nextToken())-1; //현재 자석번호 입력 (1이면 index=0이니까 -1해줌)
				int direction = Integer.parseInt(st.nextToken()); // 방향 입력
				int[] directions = new int[4]; // 비교만 먼저 해주고 이동은 나중에 해줘야하니 이동방향을 배열에 미리 입력해둠
				directions[magnetNum] = direction; // 첫번째 이동할 자석 index에 방향 넣어주삼
				
				int a = 6; int b = 2; // 왼쪽/오른쪽이랑 비교할 때 인덱스가 뒤집어져서 그거 바꿔주려고 변수로 생성함

				for (int d=0; d<2; d++) { //왼쪽 쭉 확인, 오른쪽 쭉 확인
					// 방향마다 초기화해주어야함
					int conNum = magnetNum; //현재 자석
					int newNum = magnetNum + dx[d]; // 비교할 자석
					int tmpDirection = direction; // 현재 방향

					while (newNum >= 0 && newNum <4) {
						// 안돌면 그 이후는 돌리면 X -> 그냥 반복을 아예 멈춰야함
						if (magnets.get(conNum).get(a) == magnets.get(newNum).get(b)) break;
						tmpDirection *= -1; // 돌릴 떄 방향 반대로 뒤집어줘야됨
						directions[newNum] = tmpDirection; // 이 방향을 기억하기 위해 방향 배열에 입력해둠
						conNum = newNum;
						newNum += dx[d];
					}
					
					a = 2; b = 6; // 왼쪽 다 돌았으면 오른쪽 비교하는걸로 idx 갱신해줘야함
					
				}
				
				// 비교는 다 끝났고, 실제 이동시킴
				// 다 끝나기 전에 이동하면 비교할 값이 바뀌기 떄문에 안됨 ..
				for (int i=0; i<4; i++) {
					move(directions[i],magnets.get(i));
				}
			}
			
			sb.append("#").append(t).append(" ").append(score()).append("\n");
		}
		System.out.println(sb);
	}

}
