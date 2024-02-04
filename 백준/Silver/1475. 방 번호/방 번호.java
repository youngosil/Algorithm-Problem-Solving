import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //9를 제외하고 0~8까지 9개 숫자의 cnt를 담을 배열을 선언
        int[] arr = new int[9];
        
        // 입력받는 숫자를 index로 두고,
        // 해당 index의 cnt를 늘려줌
        String num = br.readLine();
        for (int i=0; i<num.length(); i++) {
            int value = num.charAt(i)-'0';
            // 단 9일때는 index가 6인 값의 cnt를 늘려줌
            if (value==9) {
                arr[6]++;
            } else {
                arr[value]++;
            }
        }
        
        // 9와 6의 cnt를 더한 뒤 반올림해줘야함
        if (arr[6]%2==0) {
            arr[6] /= 2;
        } else if (arr[6]%2==1) {
            arr[6] = arr[6]/2+1;
        }
        
        // 다시 배열을 돌면서 최대 cnt를 추출
        int max = 0;
        for (int cnt : arr) {
            max = Math.max(max,cnt);
        }
        
        bw.write(Integer.toString(max));
        bw.close();
        br.close();
        
    }
}