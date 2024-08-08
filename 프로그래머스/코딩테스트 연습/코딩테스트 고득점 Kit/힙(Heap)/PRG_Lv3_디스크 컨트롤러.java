import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        
        int n = jobs.length, index = 0, end = 0, count = 0, answer = 0;

        while (count < n) {
            while (index < n && jobs[index][0] <= end) {
                pq.offer(jobs[index++]);
            }

            if (pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] disk = pq.poll();
                answer += (end - disk[0] + disk[1]);
                end += disk[1];
                count++;
            }
        }
        
        return answer / n;
    }
}

// 테스트 1 〉	통과 (3.77ms, 78.5MB)
// 테스트 2 〉	통과 (2.97ms, 72.9MB)
// 테스트 3 〉	통과 (3.23ms, 81.3MB)
// 테스트 4 〉	통과 (3.02ms, 76.7MB)
// 테스트 5 〉	통과 (2.95ms, 80.7MB)
// 테스트 6 〉	통과 (1.62ms, 68.1MB)
// 테스트 7 〉	통과 (2.65ms, 72.7MB)
// 테스트 8 〉	통과 (1.90ms, 75.5MB)
// 테스트 9 〉	통과 (2.00ms, 76.9MB)
// 테스트 10 〉	통과 (2.86ms, 73.9MB)
// 테스트 11 〉	통과 (1.05ms, 75.1MB)
// 테스트 12 〉	통과 (1.06ms, 75MB)
// 테스트 13 〉	통과 (1.39ms, 76.5MB)
// 테스트 14 〉	통과 (1.41ms, 68.4MB)
// 테스트 15 〉	통과 (1.48ms, 81.2MB)
// 테스트 16 〉	통과 (1.05ms, 73.6MB)
// 테스트 17 〉	통과 (1.46ms, 82.8MB)
// 테스트 18 〉	통과 (1.39ms, 69.9MB)
// 테스트 19 〉	통과 (1.09ms, 77.8MB)
// 테스트 20 〉	통과 (1.15ms, 70.7MB)
