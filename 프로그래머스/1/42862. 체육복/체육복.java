import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        for (int i=0; i<lost.length; i++) {
            arr[lost[i]-1]--;
        }
        
        for (int i=0; i<reserve.length; i++) {
            arr[reserve[i]-1]++;
        }
        
        for (int i=0; i<n; i++) {
            if (arr[i]==2) {
                if (i>=1 && arr[i-1]==0) {
                    arr[i]--; arr[i-1]++;
                } else if (i<n-1 && arr[i+1]==0) {
                    arr[i]--; arr[i+1]++;
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            if (arr[i]!=0) answer++;
        }
        
        return answer;
    }
}