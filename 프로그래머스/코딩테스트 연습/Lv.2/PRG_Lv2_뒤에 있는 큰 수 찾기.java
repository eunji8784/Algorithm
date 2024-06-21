import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            int num = numbers[i];
            while (!stack.isEmpty()) {
                int idx = stack.peek();
                if (numbers[idx] < num) {
                    answer[idx] = num;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
