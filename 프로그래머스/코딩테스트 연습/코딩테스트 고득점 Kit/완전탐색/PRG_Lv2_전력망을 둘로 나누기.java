import java.util.*;

class Solution {
    private static class Node {
        int idx, num;
        
        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            graph.get(wires[i][0]).add(new Node(i, wires[i][1]));
            graph.get(wires[i][1]).add(new Node(i, wires[i][0]));
        }
        
        for (int i = 0; i < n - 1; i++) {
            answer = Math.min(answer, bfs(n, i, graph));
        }
        
        return answer;
    }
    
    private static int bfs(int n, int idx, List<List<Node>> graph) {
        boolean[] vst = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        int count = 1;      
        
        que.offer(1);
        vst[1] = true;
        
        while (!que.isEmpty()) {
            int now = que.poll();         
            for (Node next : graph.get(now)) {
                if (next.idx != idx && !vst[next.num]) {
                    vst[next.num] = true;
                    que.offer(next.num);
                    count++;
                }
            }
        }
        
        return Math.abs(n - (count * 2));
    }
}

// 테스트 1 〉	통과 (4.95ms, 79MB)
// 테스트 2 〉	통과 (5.17ms, 75.8MB)
// 테스트 3 〉	통과 (4.13ms, 77.3MB)
// 테스트 4 〉	통과 (4.37ms, 73.9MB)
// 테스트 5 〉	통과 (4.10ms, 74.9MB)
// 테스트 6 〉	통과 (0.34ms, 81.4MB)
// 테스트 7 〉	통과 (0.41ms, 75.8MB)
// 테스트 8 〉	통과 (1.09ms, 70.7MB)
// 테스트 9 〉	통과 (1.15ms, 70MB)
// 테스트 10 〉	통과 (4.68ms, 74.2MB)
// 테스트 11 〉	통과 (4.73ms, 77.6MB)
// 테스트 12 〉	통과 (6.77ms, 71.4MB)
// 테스트 13 〉	통과 (4.53ms, 83.7MB)
