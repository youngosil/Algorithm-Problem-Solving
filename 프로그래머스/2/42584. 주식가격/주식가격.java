import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (len-1) - idx;
        }
        
        
        return answer;
    }
}