import java.util.*;

class Solution {
    private static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        solve(k, 0, new boolean[dungeons.length], dungeons);
        return answer;
    }
    
    private static void solve(int score, int count, boolean[] vst, int[][] dungeons) {    
        for (int i = 0; i < dungeons.length; i++) {
            if (!vst[i] && score >= dungeons[i][0]) {
                vst[i] = true;
                solve(score - dungeons[i][1], count + 1, vst, dungeons);
                vst[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}

// 테스트 1 〉	통과 (0.03ms, 74.2MB)
// 테스트 2 〉	통과 (0.04ms, 75.7MB)
// 테스트 3 〉	통과 (0.04ms, 73.6MB)
// 테스트 4 〉	통과 (0.14ms, 69.5MB)
// 테스트 5 〉	통과 (0.32ms, 75.2MB)
// 테스트 6 〉	통과 (0.46ms, 73.7MB)
// 테스트 7 〉	통과 (1.47ms, 74.6MB)
// 테스트 8 〉	통과 (2.64ms, 75.7MB)
// 테스트 9 〉	통과 (0.03ms, 72.6MB)
// 테스트 10 〉	통과 (0.31ms, 76.1MB)
// 테스트 11 〉	통과 (0.03ms, 75.3MB)
// 테스트 12 〉	통과 (0.47ms, 78.9MB)
// 테스트 13 〉	통과 (0.11ms, 72MB)
// 테스트 14 〉	통과 (0.12ms, 73.9MB)
// 테스트 15 〉	통과 (0.04ms, 75.2MB)
// 테스트 16 〉	통과 (0.04ms, 86.8MB)
// 테스트 17 〉	통과 (0.05ms, 77.3MB)
// 테스트 18 〉	통과 (0.09ms, 72.5MB)
// 테스트 19 〉	통과 (0.04ms, 73.8MB)
