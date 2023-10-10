import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for (int[] command : commands) {
            int[] result = new int[command[1] - command[0] + 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = array[command[0] - 1 + i];
            }
            Arrays.sort(result);
            answer[idx++] = result[command[2] - 1];
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.31ms, 79.2MB)
// 테스트 2 〉	통과 (0.52ms, 77.3MB)
// 테스트 3 〉	통과 (0.34ms, 78.1MB)
// 테스트 4 〉	통과 (0.49ms, 75.7MB)
// 테스트 5 〉	통과 (0.57ms, 75.5MB)
// 테스트 6 〉	통과 (0.42ms, 71.8MB)
// 테스트 7 〉	통과 (0.34ms, 84.6MB)
