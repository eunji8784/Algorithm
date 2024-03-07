import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int max = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = n - 1; i >= 0; i--) {
            int min = (int)Math.min(citations[i], n - i);
            max = Math.max(max, min);
        }
        
        return max;
    }
}
