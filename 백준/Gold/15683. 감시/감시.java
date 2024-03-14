import java.io.*;
import java.util.*;

class Coup {
    int x, y, type;

    Coup(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Main {

    static int N, M, board[][], arr[], min, tmpBoard[][];
    static List<Coup> locations;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        board = new int[N][M];
        min = Integer.MAX_VALUE;
        locations =new ArrayList<>();
        
        // cctv 입력받기
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int num = Integer.parseInt(st.nextToken());
                board[r][c] = num;

                // 아니지만 cctv가 있는 경우 후보 리스트에 넣어
                if (num >= 1 && num <= 5) {
                    locations.add(new Coup(r, c, num));
                }

            }
        }

        
        // 각 cctv의 방향set의 종류를 0,1,2,3으로 나타냄
        // 그리고 이 숫자를 담을 배열 arr를 생성 (cctv 개수만큼)
        arr = new int[locations.size()];
        recur(0);
        System.out.println(min);

    }
    
    // 2차원 배열 깊은 복사하는 메서드
    static void getTmpBoard() {
        int R = board.length;
        int C = board[0].length;
        tmpBoard = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmpBoard[r][c] = board[r][c];
            }
        }
    }

    // cctv 감시 구역 색칠하는 메소드 (위치와 방향 주어지면 색칠)
    public static void paint(int[][] whichBoard, int r, int c, int d) {

        int nr = r + dr[d];
        int nc = c + dc[d];
        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
            if (whichBoard[nr][nc] == 6) {
                break; // 벽이면 그만
            }
            if (whichBoard[nr][nc] == 0) { // 비었으ss면 감시
                whichBoard[nr][nc] = -1;
            }
            // 아니면 그냥 색칠 안하고 넘어가긴 함
            nr += dr[d];
            nc += dc[d];
        }
    }
    

    static void mainFunc(List<Coup> locations, int[] arr) {
        int[] directions;

        // 한 방향 set의 cctv가 볼 수 있는 방향을 모두 색칠
        for (int i = 0; i < locations.size(); i++) {
            int tmpR = locations.get(i).x;
            int tmpC = locations.get(i).y;

            // 살펴볼 방향 배열
            directions = getDelta(locations.get(i).type, arr[i]);

            for (int j = 0; j < directions.length; j++) {
                paint(tmpBoard, tmpR, tmpC, directions[j]);
            }

        }

    }

//    static void print(int[][] b) {
//        for (int r = 0; r < N; r++) {
//            for (int c = 0; c < M; c++) {
//                System.out.print(b[r][c] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------------");
//    }

    // cctv의 종류와 감시 방향에 따라 살펴봐야할 방향 배열을 반환하는 함수 함수
    static int[] getDelta(int type, int direction) {

        int[] tmp;

        if (type == 1) {
            // 방향이 곧 index
            tmp = new int[1];
            tmp[0] = direction;
        } else if (type == 2) {
            tmp = new int[2];
            if (direction % 2 == 0) {
                tmp[0] = 0;
                tmp[1] = 1;
            } else {
                tmp[0] = 2;
                tmp[1] = 3;
            }
        } else if (type == 3) {
            tmp = new int[2];
            if (direction == 0) {
                tmp[0] = 0;
                tmp[1] = 3;
            } else if (direction == 1) {
                tmp[0] = 1;
                tmp[1] = 3;
            } else if (direction == 2) {
                tmp[0] = 0;
                tmp[1] = 2;
            } else {
                tmp[0] = 1;
                tmp[1] = 2;
            }

        } else if (type==4){
            tmp = new int[3];
            if (direction == 0) {
                tmp[0] = 0;
                tmp[1] = 2;
                tmp[2] = 3;
            } else if (direction == 1) {
                tmp[0] = 0;
                tmp[1] = 1;
                tmp[2] = 3;
            } else if (direction == 2) {
                tmp[0] = 1;
                tmp[1] = 2;
                tmp[2] = 3;
            } else {
                tmp[0] = 0;
                tmp[1] = 1;
                tmp[2] = 2;
            }
        } else {
        	tmp = new int[] {0,1,2,3};
        }

        return tmp;
    }

    // 사각지대 수 세는 메소드
    static int count(int[][] board) {
        int cnt = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0)
                    cnt++;
            }
        }

        return cnt;
    }

    static void recur(int idx) {
    	// 방향 배열이 완성될때마다
        if (idx == locations.size()) {
            getTmpBoard(); // 한 색칠set마다 판을 새걸로 다시 교체
            mainFunc(locations, arr); // 색칠하기
            
            int cnt = count(tmpBoard); // 사각지대 세기
//            if (min>cnt) {
//            	System.out.println("min"+min+" cnt"+cnt);
//            	print(tmpBoard);
//            }
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[idx] = i;
            recur(idx + 1);
        }
  
    }

}