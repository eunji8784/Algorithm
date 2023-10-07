import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = -1;
        int maxHeight = -1;
        
        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(width, maxWidth);
            maxHeight = Math.max(height, maxHeight);
        }
        
        return maxWidth * maxHeight;
    }
}

// 테스트 1 〉	통과 (0.02ms, 71.3MB)
// 테스트 2 〉	통과 (0.03ms, 67.7MB)
// 테스트 3 〉	통과 (0.03ms, 76.1MB)
// 테스트 4 〉	통과 (0.02ms, 70.8MB)
// 테스트 5 〉	통과 (0.03ms, 76.1MB)
// 테스트 6 〉	통과 (0.04ms, 78MB)
// 테스트 7 〉	통과 (0.03ms, 80MB)
// 테스트 8 〉	통과 (0.03ms, 73.6MB)
// 테스트 9 〉	통과 (0.03ms, 77.9MB)
// 테스트 10 〉	통과 (0.06ms, 73.2MB)
// 테스트 11 〉	통과 (0.06ms, 83.6MB)
// 테스트 12 〉	통과 (0.06ms, 77MB)
// 테스트 13 〉	통과 (0.17ms, 78MB)
// 테스트 14 〉	통과 (0.40ms, 88.7MB)
// 테스트 15 〉	통과 (0.46ms, 82.2MB)
// 테스트 16 〉	통과 (0.65ms, 80.4MB)
// 테스트 17 〉	통과 (1.79ms, 91.5MB)
// 테스트 18 〉	통과 (1.80ms, 88.3MB)
// 테스트 19 〉	통과 (1.75ms, 84.4MB)
// 테스트 20 〉	통과 (1.48ms, 88.1MB)
