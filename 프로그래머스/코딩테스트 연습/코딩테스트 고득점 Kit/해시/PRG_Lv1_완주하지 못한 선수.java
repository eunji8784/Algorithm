import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.06ms, 74.4MB)
// 테스트 2 〉	통과 (0.08ms, 68.3MB)
// 테스트 3 〉	통과 (0.78ms, 75.9MB)
// 테스트 4 〉	통과 (0.92ms, 76.2MB)
// 테스트 5 〉	통과 (1.06ms, 75.4MB)
// 테스트 6 〉	통과 (0.05ms, 65.4MB)
// 테스트 7 〉	통과 (0.07ms, 76.5MB)
// 효율성  테스트
// 테스트 1 〉	통과 (85.96ms, 81.9MB)
// 테스트 2 〉	통과 (65.04ms, 88.5MB)
// 테스트 3 〉	통과 (77.75ms, 94.3MB)
// 테스트 4 〉	통과 (83.65ms, 95.7MB)
// 테스트 5 〉	통과 (83.25ms, 97.3MB)
