import java.util.*;

class Solution {
    private static final int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    private static int[] picks;
    private static String[] minerals;
    private static int answer;
    
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        answer = Integer.MAX_VALUE;
        
        int total = 0;
        for (int count : picks) total += count;

        backtracking(0, 0, total);
        
        return answer;
    }

    private void backtracking(int count, int sum, int total) {
        if (sum >= answer) {
            return;
        }
        
        if (count == minerals.length || total == 0) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;

            picks[i]--;
            int seq = 5, tmpSum = 0, idx = count;
            
            while (seq-- > 0 && idx < minerals.length) {
                String mineral = minerals[idx++];
                switch (mineral) {
                    case "diamond": tmpSum += fatigue[i][0];
                        break;
                    case "iron": tmpSum += fatigue[i][1];
                        break;
                    case "stone": tmpSum += fatigue[i][2];
                        break;
                }
            }

            backtracking(idx, sum + tmpSum, total - 1);
            
            picks[i]++;
        }
    }
}

// 테스트 1 〉	통과 (0.06ms, 75.6MB)
// 테스트 2 〉	통과 (0.09ms, 74.7MB)
// 테스트 3 〉	통과 (0.04ms, 70.4MB)
// 테스트 4 〉	통과 (0.08ms, 72.5MB)
// 테스트 5 〉	통과 (0.08ms, 73.7MB)
// 테스트 6 〉	통과 (0.07ms, 75.5MB)
// 테스트 7 〉	통과 (0.05ms, 75.9MB)
// 테스트 8 〉	통과 (0.04ms, 79.1MB)
// 테스트 9 〉	통과 (0.07ms, 77.6MB)
// 테스트 10 〉	통과 (0.04ms, 79.4MB)
// 테스트 11 〉	통과 (0.38ms, 77.6MB)
// 테스트 12 〉	통과 (0.12ms, 74.3MB)
// 테스트 13 〉	통과 (0.36ms, 77.4MB)
// 테스트 14 〉	통과 (0.15ms, 76.2MB)
// 테스트 15 〉	통과 (0.14ms, 77.4MB)
// 테스트 16 〉	통과 (0.04ms, 76.6MB)
// 테스트 17 〉	통과 (0.07ms, 71.8MB)
// 테스트 18 〉	통과 (0.04ms, 74.1MB)
// 테스트 19 〉	통과 (0.07ms, 75.7MB)
// 테스트 20 〉	통과 (0.06ms, 73.4MB)
// 테스트 21 〉	통과 (0.07ms, 71.7MB)
// 테스트 22 〉	통과 (0.15ms, 70MB)
// 테스트 23 〉	통과 (0.07ms, 76.3MB)
// 테스트 24 〉	통과 (1.26ms, 82.7MB)
// 테스트 25 〉	통과 (0.50ms, 77.5MB)
// 테스트 26 〉	통과 (0.39ms, 76.2MB)
// 테스트 27 〉	통과 (0.10ms, 72.6MB)
// 테스트 28 〉	통과 (0.38ms, 77.2MB)
// 테스트 29 〉	통과 (0.16ms, 76.9MB)
// 테스트 30 〉	통과 (0.06ms, 74.4MB)
// 테스트 31 〉	통과 (0.06ms, 76.2MB)
// 테스트 32 〉	통과 (0.14ms, 76.5MB)
// 테스트 33 〉	통과 (0.10ms, 75.1MB)
// 테스트 34 〉	통과 (0.16ms, 74MB)
// 테스트 35 〉	통과 (0.13ms, 75MB)
