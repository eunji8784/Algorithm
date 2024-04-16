import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int lo = 1, hi = distance;
        
        while (lo <= hi) {
            int removeCnt = 0, prev = 0;
            int mid = lo + (hi - lo) / 2;
            
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removeCnt++;
                } else {
                    prev = rock;
                }
            }
            
            if (distance - prev < mid) {
                removeCnt++;
            }
            
            if (removeCnt > n) {
                hi = mid - 1;
            } else {
                answer = mid;
                lo = mid + 1;
            }
        }
        
        return answer;
    }
}
