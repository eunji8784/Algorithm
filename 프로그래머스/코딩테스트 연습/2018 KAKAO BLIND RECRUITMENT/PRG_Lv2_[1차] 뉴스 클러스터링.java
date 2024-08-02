import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2).toLowerCase();
            if (str.replaceAll("[^a-zA-Z]", "").length() < 2) {
                continue;
            }
            map1.put(str, map1.getOrDefault(str, 0) + 1);
            set1.add(str);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2).toLowerCase();
            if (str.replaceAll("[^a-zA-Z]", "").length() < 2) {
                continue;
            }
            map2.put(str, map2.getOrDefault(str, 0) + 1);
            set2.add(str);
        }

        if (set1.size() == 0 && set2.size() == 0) {
            return 65536;
        }

        set1.retainAll(set2);

        int a = 0, b = 0; // 교집합 개수, 합집합 개수
        
        for (String val : set1) {
            int val1 = map1.get(val);
            int val2 = map2.get(val);
            a += Math.min(val1, val2);
            b += Math.max(val1, val2);
            map1.remove(val);
            map2.remove(val);
        }

        for (String key : map1.keySet()) {
            b += map1.get(key);
        }

        for (String key : map2.keySet()) {
            b += map2.get(key);
        }
 
        return (int) (a / (double) b * 65536);
    }
}

// 테스트 1 〉	통과 (0.59ms, 73.9MB)
// 테스트 2 〉	통과 (0.86ms, 73.1MB)
// 테스트 3 〉	통과 (0.48ms, 65.6MB)
// 테스트 4 〉	통과 (17.87ms, 77.7MB)
// 테스트 5 〉	통과 (1.71ms, 75.3MB)
// 테스트 6 〉	통과 (0.31ms, 72.9MB)
// 테스트 7 〉	통과 (3.90ms, 79.8MB)
// 테스트 8 〉	통과 (1.15ms, 73.7MB)
// 테스트 9 〉	통과 (2.80ms, 77.7MB)
// 테스트 10 〉	통과 (8.37ms, 74.8MB)
// 테스트 11 〉	통과 (7.05ms, 78.4MB)
// 테스트 12 〉	통과 (0.47ms, 79.7MB)
// 테스트 13 〉	통과 (1.83ms, 75.5MB)
