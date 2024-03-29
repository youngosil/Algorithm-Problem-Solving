import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 변수 초기화
        PriorityQueue<Integer> pqA = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> pqB = new PriorityQueue<>((o1,o2)->o2-o1); // 내림차순
        
        int result = 0;

        // pqA, pqB
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            pqA.offer(Integer.parseInt(stA.nextToken()));
            pqB.offer(Integer.parseInt(stB.nextToken()));
        }
        
        while (!pqA.isEmpty() && !pqB.isEmpty()) {
            result += pqB.poll()*pqA.poll(); //위배열 가장 작은것 * 밑 배열 가장 큰 것 곱해줌 (반대로도 상관 없음)
        }
        
        System.out.println(result);
    }
}