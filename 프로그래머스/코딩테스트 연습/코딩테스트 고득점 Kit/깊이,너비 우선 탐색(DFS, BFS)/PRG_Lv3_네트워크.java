import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] vst = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!vst[i]) {
                bfs(i, n, computers, vst);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int start, int n, int[][] computers, boolean[] vst) {
        Queue<Integer> que = new LinkedList<>();
        
        que.offer(start);
        vst[start] = true;
        
        while (!que.isEmpty()) {
            int now = que.poll();
            
            for (int i = 0; i < n; i++) {
                if (vst[i] || computers[now][i] == 0) continue;
                que.offer(i);
                vst[i] = true;
            }
        }
    }
}

// 테스트 1 〉	통과 (0.14ms, 74.2MB)
// 테스트 2 〉	통과 (0.16ms, 75.4MB)
// 테스트 3 〉	통과 (0.19ms, 75.3MB)
// 테스트 4 〉	통과 (0.24ms, 86.6MB)
// 테스트 5 〉	통과 (0.16ms, 76.4MB)
// 테스트 6 〉	통과 (0.19ms, 74.2MB)
// 테스트 7 〉	통과 (0.16ms, 81.1MB)
// 테스트 8 〉	통과 (0.26ms, 82.6MB)
// 테스트 9 〉	통과 (0.23ms, 83.8MB)
// 테스트 10 〉	통과 (0.17ms, 73MB)
// 테스트 11 〉	통과 (0.49ms, 81.7MB)
// 테스트 12 〉	통과 (0.50ms, 78.7MB)
// 테스트 13 〉	통과 (0.22ms, 71.6MB)
