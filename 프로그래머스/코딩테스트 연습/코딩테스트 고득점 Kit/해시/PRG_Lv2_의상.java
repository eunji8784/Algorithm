import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        for (String key : map.keySet()) answer *= (map.get(key) + 1);
        return --answer;
    }
}

// 테스트 1 〉	통과 (0.11ms, 73.5MB)
// 테스트 2 〉	통과 (0.05ms, 75.8MB)
// 테스트 3 〉	통과 (0.06ms, 75.1MB)
// 테스트 4 〉	통과 (0.07ms, 76MB)
// 테스트 5 〉	통과 (0.08ms, 75.9MB)
// 테스트 6 〉	통과 (0.07ms, 68MB)
// 테스트 7 〉	통과 (0.09ms, 74.1MB)
// 테스트 8 〉	통과 (0.05ms, 72.7MB)
// 테스트 9 〉	통과 (0.06ms, 74.2MB)
// 테스트 10 〉	통과 (0.05ms, 74.9MB)
// 테스트 11 〉	통과 (0.03ms, 76.3MB)
// 테스트 12 〉	통과 (0.07ms, 73.6MB)
// 테스트 13 〉	통과 (0.10ms, 84.8MB)
// 테스트 14 〉	통과 (0.07ms, 68MB)
// 테스트 15 〉	통과 (0.04ms, 71.6MB)
// 테스트 16 〉	통과 (0.05ms, 81MB)
// 테스트 17 〉	통과 (0.05ms, 74.1MB)
// 테스트 18 〉	통과 (0.07ms, 79.3MB)
// 테스트 19 〉	통과 (0.05ms, 72.4MB)
// 테스트 20 〉	통과 (0.05ms, 77.2MB)
// 테스트 21 〉	통과 (0.06ms, 75.7MB)
// 테스트 22 〉	통과 (0.05ms, 81.8MB)
// 테스트 23 〉	통과 (0.06ms, 77.1MB)
// 테스트 24 〉	통과 (0.05ms, 74.4MB)
// 테스트 25 〉	통과 (0.06ms, 75.6MB)
// 테스트 26 〉	통과 (0.08ms, 79.9MB)
// 테스트 27 〉	통과 (0.05ms, 78.4MB)
// 테스트 28 〉	통과 (0.07ms, 73.4MB)
