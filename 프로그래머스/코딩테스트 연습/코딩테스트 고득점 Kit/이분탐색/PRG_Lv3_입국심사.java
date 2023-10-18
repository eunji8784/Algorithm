import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long lo = 1;
        long hi = 0;
        for (int time : times) hi = Math.max(hi, time);
        hi *= n;
        
        while (lo < hi) {
            long mid = lo + ((hi - lo) / 2);
            long key = 0;
            for (int time : times) key += (mid / time);
            
            if (key < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}

// 테스트 1 〉	통과 (0.14ms, 73.5MB)
// 테스트 2 〉	통과 (0.16ms, 72.7MB)
// 테스트 3 〉	통과 (1.81ms, 71.9MB)
// 테스트 4 〉	통과 (50.60ms, 95.7MB)
// 테스트 5 〉	통과 (47.71ms, 90.2MB)
// 테스트 6 〉	통과 (62.98ms, 93.8MB)
// 테스트 7 〉	통과 (65.35ms, 86.7MB)
// 테스트 8 〉	통과 (55.53ms, 85.6MB)
// 테스트 9 〉	통과 (0.08ms, 85.3MB)
