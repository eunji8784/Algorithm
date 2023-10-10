import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        
        while (start <= end) {
            if (people[start] + people[end] <= limit) start++;
            end--;
            answer++;
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (2.12ms, 78.9MB)
// 테스트 2 〉	통과 (1.04ms, 70.5MB)
// 테스트 3 〉	통과 (1.71ms, 75.5MB)
// 테스트 4 〉	통과 (1.26ms, 77.5MB)
// 테스트 5 〉	통과 (0.91ms, 78MB)
// 테스트 6 〉	통과 (0.65ms, 78.7MB)
// 테스트 7 〉	통과 (1.08ms, 74.1MB)
// 테스트 8 〉	통과 (0.51ms, 75.5MB)
// 테스트 9 〉	통과 (0.44ms, 74.5MB)
// 테스트 10 〉	통과 (1.11ms, 71MB)
// 테스트 11 〉	통과 (1.78ms, 76.3MB)
// 테스트 12 〉	통과 (1.50ms, 79.2MB)
// 테스트 13 〉	통과 (1.03ms, 75.5MB)
// 테스트 14 〉	통과 (1.27ms, 72.7MB)
// 테스트 15 〉	통과 (0.60ms, 83.1MB)
// 테스트 16 〉	통과 (0.35ms, 73.6MB)
// 테스트 17 〉	통과 (0.44ms, 73.4MB)
// 테스트 18 〉	통과 (0.35ms, 76.4MB)
// 테스트 19 〉	통과 (0.53ms, 64.7MB)
// 테스트 20 〉	통과 (0.55ms, 78.3MB)
// 테스트 21 〉	통과 (0.41ms, 76.9MB)
// 테스트 22 〉	통과 (0.51ms, 76.7MB)
// 효율성  테스트
// 테스트 1 〉	통과 (10.56ms, 54MB)
// 테스트 2 〉	통과 (14.05ms, 61.9MB)
// 테스트 3 〉	통과 (10.47ms, 54MB)
// 테스트 4 〉	통과 (7.35ms, 55MB)
// 테스트 5 〉	통과 (8.82ms, 53.6MB)
