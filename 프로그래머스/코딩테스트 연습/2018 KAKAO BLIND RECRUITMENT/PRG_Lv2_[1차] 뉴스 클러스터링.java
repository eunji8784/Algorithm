import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 풀이1.
        // Map<String, Integer> map1 = new HashMap<>();
        // Map<String, Integer> map2 = new HashMap<>();
        // Set<String> set1 = new HashSet<>();
        // Set<String> set2 = new HashSet<>();

        // str1 = str1.toLowerCase();
        // str2 = str2.toLowerCase();

        // for (int i = 0; i < str1.length() - 1; i++) {
        //     String str = str1.substring(i, i + 2);
        //     if (str.replaceAll("[^a-z]", "").length() < 2) {
        //         continue;
        //     }
        //     map1.put(str, map1.getOrDefault(str, 0) + 1);
        //     set1.add(str);
        // }

        // for (int i = 0; i < str2.length() - 1; i++) {
        //     String str = str2.substring(i, i + 2);
        //     if (str.replaceAll("[^a-z]", "").length() < 2) {
        //         continue;
        //     }
        //     map2.put(str, map2.getOrDefault(str, 0) + 1);
        //     set2.add(str);
        // }

        // if (set1.size() == 0 && set2.size() == 0) {
        //     return 65536;
        // }

        // set1.retainAll(set2);

        // int a = 0, b = 0; // 교집합 개수, 합집합 개수
        
        // for (String val : set1) {
        //     int val1 = map1.get(val);
        //     int val2 = map2.get(val);
        //     a += Math.min(val1, val2);
        //     b += Math.max(val1, val2);
        //     map1.remove(val);
        //     map2.remove(val);
        // }

        // for (String key : map1.keySet()) {
        //     b += map1.get(key);
        // }

        // for (String key : map2.keySet()) {
        //     b += map2.get(key);
        // }

        // 풀이2.
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String str = null;

        for (int i = 0; i < str1.length() - 1; i++) {
            str = str1.substring(i, i + 2);
            if (str.replaceAll("[^a-z]", "").length() < 2) {
                continue;
            }
            lst1.add(str);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            str = str2.substring(i, i + 2);
            if (str.replaceAll("[^a-z]", "").length() < 2) {
                continue;
            }
            lst2.add(str);
        }

        if (lst1.size() == 0 && lst2.size() == 0) {
            return 65536;
        }

        int a = 0, b = 0; // 교집합 개수, 합집합 개수
        
        for (String val : lst1) {
            if (lst2.remove(val)) a++;
            b++;
        }

        b += lst2.size();

        return (int) (a / (double) b * 65536);
    }
}

// 풀이1.
// 테스트 1 〉	통과 (0.31ms, 73.2MB)
// 테스트 2 〉	통과 (0.47ms, 72.5MB)
// 테스트 3 〉	통과 (0.52ms, 71.8MB)
// 테스트 4 〉	통과 (14.87ms, 78.1MB)
// 테스트 5 〉	통과 (1.52ms, 72.8MB)
// 테스트 6 〉	통과 (0.40ms, 77.2MB)
// 테스트 7 〉	통과 (2.57ms, 83MB)
// 테스트 8 〉	통과 (0.60ms, 71.5MB)
// 테스트 9 〉	통과 (2.79ms, 83.9MB)
// 테스트 10 〉	통과 (4.44ms, 72.1MB)
// 테스트 11 〉	통과 (6.59ms, 83.4MB)
// 테스트 12 〉	통과 (0.37ms, 85.4MB)
// 테스트 13 〉	통과 (1.55ms, 74.1MB)

// 풀이2.
// 테스트 1 〉	통과 (0.41ms, 76.3MB)
// 테스트 2 〉	통과 (0.46ms, 77.1MB)
// 테스트 3 〉	통과 (0.46ms, 73.6MB)
// 테스트 4 〉	통과 (14.49ms, 87.5MB)
// 테스트 5 〉	통과 (1.52ms, 67.2MB)
// 테스트 6 〉	통과 (0.24ms, 73.7MB)
// 테스트 7 〉	통과 (10.96ms, 70.2MB)
// 테스트 8 〉	통과 (1.13ms, 84.8MB)
// 테스트 9 〉	통과 (2.38ms, 73.3MB)
// 테스트 10 〉	통과 (6.23ms, 79.9MB)
// 테스트 11 〉	통과 (7.85ms, 76MB)
// 테스트 12 〉	통과 (0.61ms, 73.6MB)
// 테스트 13 〉	통과 (1.33ms, 77.5MB)
