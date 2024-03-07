import java.io.*;
import java.util.*;

public class Main {

    static int K,N,arr[];
    static long cut(long number) {
    	long cnt=0;
        
        for (int n : arr) {
            cnt+=(n/number);
        }
        
        return cnt;
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[K];
        for (int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        
        Arrays.sort(arr);

        // 구상한 알고리즘
        // 최소 길이부터 최대길이까지 이분 탐색하면서 최적의 길이를 찾음
        // 단, 이분 탐색 시 비교의 대상은 총 잘려진 개수 (메소드 활용)
        long left = 1;
        long right = arr[K-1];
        long mid = (left+right)/2;
        long result = 1;
                
        while (left<=right) {
            mid = (left+right)/2;
            long tmp = cut(mid);
            
            if (tmp<N) {
                right = mid-1;
            } else if (tmp>=N) {
            	result = mid;
                left = mid+1;
            }
        }
        
        System.out.println(result);
    }

}