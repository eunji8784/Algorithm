class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length - 1;
        int[] answer = {0, n};
        
        int p1 = 0, p2 = 0, sum = sequence[p1];
        
        while (p1 <= p2) {   
            if (sum <= k) {
                if (sum == k) {
                    if (p2 - p1 < answer[1] - answer[0]) {
                        answer[0] = p1;
                        answer[1] = p2;
                    }
                }
                if (++p2 <= n) {
                    sum += sequence[p2];
                } else {
                    break;
                }
            }
            
            if (sum > k) {
                sum -= sequence[p1];
                p1++;
            }
        }
        
        return answer;
    }
}
