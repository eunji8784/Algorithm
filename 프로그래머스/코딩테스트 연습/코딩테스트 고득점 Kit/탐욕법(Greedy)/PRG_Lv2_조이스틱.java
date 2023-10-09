import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        int len = name.length();
        
        for (int i = 0; i < len; i++) {
            char now = name.charAt(i);    
            answer += (now <= 'N' ? now - 'A' : 'Z' - now + 1);
            
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') next++;
            move = Math.min(move, Math.min(i * 2 + len - next, (len - next) * 2 + i));
        }
        
        return answer + move;
    }
}

// 테스트 1 〉	통과 (0.03ms, 72.8MB)
// 테스트 2 〉	통과 (0.05ms, 71.4MB)
// 테스트 3 〉	통과 (0.05ms, 72.8MB)
// 테스트 4 〉	통과 (0.05ms, 73.6MB)
// 테스트 5 〉	통과 (0.07ms, 78.5MB)
// 테스트 6 〉	통과 (0.06ms, 72.7MB)
// 테스트 7 〉	통과 (0.04ms, 76.7MB)
// 테스트 8 〉	통과 (0.03ms, 73.2MB)
// 테스트 9 〉	통과 (0.04ms, 81MB)
// 테스트 10 〉	통과 (0.04ms, 77.1MB)
// 테스트 11 〉	통과 (0.05ms, 79.7MB)
// 테스트 12 〉	통과 (0.04ms, 71.4MB)
// 테스트 13 〉	통과 (0.03ms, 70MB)
// 테스트 14 〉	통과 (0.03ms, 69MB)
// 테스트 15 〉	통과 (0.05ms, 81.4MB)
// 테스트 16 〉	통과 (0.04ms, 76.9MB)
// 테스트 17 〉	통과 (0.05ms, 72.7MB)
// 테스트 18 〉	통과 (0.03ms, 75.3MB)
// 테스트 19 〉	통과 (0.03ms, 79.9MB)
// 테스트 20 〉	통과 (0.05ms, 74.2MB)
// 테스트 21 〉	통과 (0.03ms, 71.5MB)
// 테스트 22 〉	통과 (0.05ms, 74.3MB)
// 테스트 23 〉	통과 (0.04ms, 85.6MB)
// 테스트 24 〉	통과 (0.05ms, 73.5MB)
// 테스트 25 〉	통과 (0.04ms, 76.8MB)
// 테스트 26 〉	통과 (0.04ms, 78.3MB)
// 테스트 27 〉	통과 (0.04ms, 75.8MB)
