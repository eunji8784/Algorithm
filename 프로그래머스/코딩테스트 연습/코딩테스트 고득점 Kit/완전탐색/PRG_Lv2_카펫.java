import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 3;
        while (true) {
            int y = (brown + yellow) % x == 0 ? (brown + yellow) / x : 0;
            if (y != 0 && ((x + y) * 2 + 4 == brown)) {
                answer[0] = y;
                answer[1] = x;
                break;
            }
            x++;
        }
        return answer;
    }
}

// 테스트 1 〉	통과 (0.02ms, 66.3MB)
// 테스트 2 〉	통과 (0.02ms, 75.3MB)
// 테스트 3 〉	통과 (0.03ms, 73.9MB)
// 테스트 4 〉	통과 (0.03ms, 78.8MB)
// 테스트 5 〉	통과 (0.02ms, 76.7MB)
// 테스트 6 〉	통과 (0.04ms, 70.4MB)
// 테스트 7 〉	통과 (0.03ms, 77.4MB)
// 테스트 8 〉	통과 (0.04ms, 71.7MB)
// 테스트 9 〉	통과 (0.04ms, 70.8MB)
// 테스트 10 〉	통과 (0.06ms, 76.1MB)
// 테스트 11 〉	통과 (0.01ms, 82.9MB)
// 테스트 12 〉	통과 (0.03ms, 75.6MB)
// 테스트 13 〉	통과 (0.02ms, 76.4MB)
