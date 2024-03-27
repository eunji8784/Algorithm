import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, sum = 0;
        Queue<Integer> bridgeQ = new LinkedList<>();
        Queue<Integer> waitQ = new LinkedList<>();
        
        for (int truck : truck_weights) {
            waitQ.offer(truck);
        }
        
        while (!waitQ.isEmpty()) {
            if (bridgeQ.size() < bridge_length) {
                int nextWeight = waitQ.peek();
                if (sum + nextWeight <= weight) {
                    sum += nextWeight;
                    bridgeQ.offer(waitQ.poll());
                } else {
                    bridgeQ.offer(0);
                }
                answer++;
            } else {
                sum -= bridgeQ.poll();
            }
        }
        
        return answer + bridge_length;
    }
}
