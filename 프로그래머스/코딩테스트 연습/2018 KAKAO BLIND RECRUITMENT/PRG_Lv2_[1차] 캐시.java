import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        List<String> caches = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();
            
            if (caches.contains(city)) { // cache hit
                answer++;
                caches.remove(city);
            } else { // cache miss
                answer += 5;
                if (caches.size() == cacheSize) {
                    caches.remove(0);
                }
            }
            
            caches.add(city);
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.18ms, 72.7MB)
// 테스트 2 〉	통과 (0.18ms, 81.5MB)
// 테스트 3 〉	통과 (0.21ms, 70.9MB)
// 테스트 4 〉	통과 (0.19ms, 64.2MB)
// 테스트 5 〉	통과 (0.12ms, 77.6MB)
// 테스트 6 〉	통과 (0.01ms, 76.1MB)
// 테스트 7 〉	통과 (0.03ms, 74.4MB)
// 테스트 8 〉	통과 (0.27ms, 77.5MB)
// 테스트 9 〉	통과 (0.13ms, 78.6MB)
// 테스트 10 〉	통과 (0.55ms, 74.6MB)
// 테스트 11 〉	통과 (40.12ms, 115MB)
// 테스트 12 〉	통과 (0.35ms, 76.3MB)
// 테스트 13 〉	통과 (0.60ms, 72.4MB)
// 테스트 14 〉	통과 (1.26ms, 83.1MB)
// 테스트 15 〉	통과 (1.29ms, 75.9MB)
// 테스트 16 〉	통과 (1.37ms, 81.3MB)
// 테스트 17 〉	통과 (0.02ms, 75.4MB)
// 테스트 18 〉	통과 (1.62ms, 76.9MB)
// 테스트 19 〉	통과 (2.09ms, 79.5MB)
// 테스트 20 〉	통과 (1.87ms, 74.9MB)
