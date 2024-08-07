import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        StringTokenizer st = null;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            st = new StringTokenizer(operation, " ");
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (op.equals("I")) {
                minQ.offer(num);
                maxQ.offer(num);
            } else if (op.equals("D")) {
                if (num == -1 && !minQ.isEmpty()) { 
                    maxQ.remove(minQ.poll());
                } else if (num == 1 && !maxQ.isEmpty()) {
                    minQ.remove(maxQ.poll());
                }
            }
        }

        if (!maxQ.isEmpty()) answer[0] = maxQ.poll();
        if (!minQ.isEmpty()) answer[1] = minQ.poll();
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.45ms, 71.1MB)
// 테스트 2 〉	통과 (0.85ms, 73.6MB)
// 테스트 3 〉	통과 (0.48ms, 73.9MB)
// 테스트 4 〉	통과 (0.67ms, 78.3MB)
// 테스트 5 〉	통과 (0.69ms, 79.3MB)
// 테스트 6 〉	통과 (0.54ms, 72.3MB)
// 테스트 7 〉	통과 (62.49ms, 128MB)
// 테스트 8 〉	통과 (0.63ms, 73MB)
// 테스트 9 〉	통과 (0.63ms, 80.2MB)
// 테스트 10 〉	통과 (0.56ms, 75.4MB)
