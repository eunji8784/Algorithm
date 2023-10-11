import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);
        
        while (pq.peek() < K) {    
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            pq.offer(pq.poll() + (pq.poll() * 2));
            answer++;
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.44ms, 76.2MB)
// 테스트 2 〉	통과 (0.42ms, 72.8MB)
// 테스트 3 〉	통과 (0.50ms, 66.5MB)
// 테스트 4 〉	통과 (0.33ms, 73.8MB)
// 테스트 5 〉	통과 (0.47ms, 76.9MB)
// 테스트 6 〉	통과 (1.86ms, 75.5MB)
// 테스트 7 〉	통과 (5.64ms, 74.3MB)
// 테스트 8 〉	통과 (0.97ms, 66.2MB)
// 테스트 9 〉	통과 (0.70ms, 75MB)
// 테스트 10 〉	통과 (1.79ms, 71.4MB)
// 테스트 11 〉	통과 (1.40ms, 75.1MB)
// 테스트 12 〉	통과 (2.92ms, 80.8MB)
// 테스트 13 〉	통과 (1.60ms, 70.9MB)
// 테스트 14 〉	통과 (0.41ms, 77.4MB)
// 테스트 15 〉	통과 (1.89ms, 73.9MB)
// 테스트 16 〉	통과 (0.34ms, 75.2MB)
// 테스트 17 〉	통과 (0.30ms, 77.3MB)
// 테스트 18 〉	통과 (0.39ms, 74.2MB)
// 테스트 19 〉	통과 (0.37ms, 72.4MB)
// 테스트 20 〉	통과 (0.46ms, 78.4MB)
// 테스트 21 〉	통과 (0.31ms, 78.6MB)
// 테스트 22 〉	통과 (0.44ms, 79.3MB)
// 테스트 23 〉	통과 (0.35ms, 72.6MB)
// 테스트 24 〉	통과 (0.32ms, 75.7MB)
// 테스트 25 〉	통과 (0.49ms, 78.4MB)
// 테스트 26 〉	통과 (0.34ms, 75.9MB)
// 효율성  테스트
// 테스트 1 〉	통과 (165.55ms, 67.2MB)
// 테스트 2 〉	통과 (285.35ms, 86.9MB)
// 테스트 3 〉	통과 (1419.69ms, 122MB)
// 테스트 4 〉	통과 (124.46ms, 64.3MB)
// 테스트 5 〉	통과 (1672.06ms, 123MB)
