import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
    	//입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //체스판 크기 입력받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st2.nextToken()); // N=R
        int M = Integer.parseInt(st2.nextToken()); // M=C
        char[][] arr = new char[N][M];
        
        // 배열 입력받기
        for (int r=0; r<N; r++) {
        	String line = br.readLine();
        	for (int c=0; c<M; c++) {
        		arr[r][c] = line.charAt(c);
        	}
        }
        
        // 델타 배열 생성 (우하)
        int[] dr = {0,1};
        int[] dc = {1,0};
        char[] alphabet = {'B','W'};
        int i=1;
        
        // 8*8이 가능한 시작점 n,m별로 바꾸는 개수의 최솟값을 구하고 갱신
        int minCnt = Integer.MAX_VALUE; // 최솟값 변수
        for (int n=0; n<=N-8; n++) {
        	for (int m=0; m<=M-8; m++) {
        		
        		// 1. B로 시작하는 경우
        		int cntB=0;
        		for (int r=n; r<n+8; r++) {
        			for (int c=m; c<m+8; c++) {
        				// 짝수행
        				// 각 열의 값이 B 또는 W가 아닌 경우 cnt++ 해줌.
        				// 판별은 각 열이 짝수행-짝수열, 짝수행-홀수열, 홀수행-짝수열, 홀수행-홀수열임에 따라 달라지며
        				// 'B','W'를 원소로 가지는 배열을 하나 생성해서 나머지를 활용하여 판별
        				if ((r-n)%2==0) {
        					if(arr[r][c]!=alphabet[(c-m)%2]) {
        						cntB++;
        					} else {
        					}
        				} else { //홀수행
        					if(arr[r][c]!=alphabet[(c-m+1)%2]) {
        						cntB++;
        					} else {
        					}
        				}
        			}        			
        		}

				// 2. w로 시작하는 경우
        		int cntW=0;
        		for (int r=n; r<n+8; r++) {
        			for (int c=m; c<m+8; c++) {
        				// 홀수행
        				if ((r-n)%2==0) {
        					if(arr[r][c]!=alphabet[(c-m+1)%2]) {
        						cntW++;
        					}
        				} else { //짝수행
        					if(arr[r][c]!=alphabet[(c-m)%2]) {
        						cntW++;
        					}
        				}
        			}
        		}
        		
        		int tempMin = Math.min(cntW, cntB);
        		minCnt = Math.min(minCnt,tempMin);
        	}
        }
        
        bw.write(Integer.toString(minCnt));
        bw.close();
        br.close();
        
    }
}