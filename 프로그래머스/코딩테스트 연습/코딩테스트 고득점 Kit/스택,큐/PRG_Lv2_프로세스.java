import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> que = new LinkedList<>();
        
        for (int p : priorities) {
            que.offer(p);
        }
        
        Arrays.sort(priorities);
        
        int answer = 0;
        int size = priorities.length - 1;
        
        while (!que.isEmpty()) {
            if (que.peek() != priorities[size]) {
                que.offer(que.poll());
                if (--location < 0) {
                    location = que.size() - 1;
                }
            } else {
                answer++;
                size--;
                que.poll();
                if (--location < 0) {
                    break;
                }
            }
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.69ms, 75.5MB)
// 테스트 2 〉	통과 (1.06ms, 75.4MB)
// 테스트 3 〉	통과 (0.72ms, 73.7MB)
// 테스트 4 〉	통과 (0.47ms, 76.7MB)
// 테스트 5 〉	통과 (0.62ms, 75.8MB)
// 테스트 6 〉	통과 (0.61ms, 72.9MB)
// 테스트 7 〉	통과 (0.59ms, 77.6MB)
// 테스트 8 〉	통과 (2.38ms, 75.4MB)
// 테스트 9 〉	통과 (0.65ms, 90.6MB)
// 테스트 10 〉	통과 (0.75ms, 80.1MB)
// 테스트 11 〉	통과 (1.30ms, 75MB)
// 테스트 12 〉	통과 (0.59ms, 73.2MB)
// 테스트 13 〉	통과 (0.89ms, 68.2MB)
// 테스트 14 〉	통과 (0.48ms, 73.2MB)
// 테스트 15 〉	통과 (0.59ms, 77.6MB)
// 테스트 16 〉	통과 (0.59ms, 72.4MB)
// 테스트 17 〉	통과 (1.19ms, 75.5MB)
// 테스트 18 〉	통과 (0.46ms, 74.8MB)
// 테스트 19 〉	통과 (0.97ms, 74.8MB)
// 테스트 20 〉	통과 (0.60ms, 79.4MB)
