import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        int[] alphabets = new int[26];
        int index;
        
        for (int i=0; i<word.length(); i++) {
            index = word.charAt(i) - 97;
            alphabets[index] ++;
        }
        
        for (int num : alphabets) {
            bw.write(num+" ");
        }
        
        bw.close();
        br.close();
    }
}