import java.util.*;

class Solution {
    private static int[] numbers;
    private static int target, answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private static void dfs(int num, int count) {
        if (count == numbers.length) {
            if (num == target) answer++;
            return;
        }
        
        dfs(num - numbers[count], count + 1);
        dfs(num + numbers[count], count + 1); 
    }
}

// 테스트 1 〉	통과 (9.75ms, 71.5MB)
// 테스트 2 〉	통과 (8.05ms, 87.4MB)
// 테스트 3 〉	통과 (0.19ms, 75.2MB)
// 테스트 4 〉	통과 (0.45ms, 75.9MB)
// 테스트 5 〉	통과 (0.86ms, 72.5MB)
// 테스트 6 〉	통과 (0.32ms, 77MB)
// 테스트 7 〉	통과 (0.18ms, 72.7MB)
// 테스트 8 〉	통과 (0.55ms, 71.9MB)
