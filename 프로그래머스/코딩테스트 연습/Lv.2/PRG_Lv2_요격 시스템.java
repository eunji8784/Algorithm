import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> (o1[0] - o2[0]));
        int[] interval = {0, 100000000};

        for (int[] target : targets) {
            int s = target[0], e = target[1];
            if (s >= interval[0] && e <= interval[1]) {
                interval[0] = s;
                interval[1] = e;
            } else if (s >= interval[1]) {
                answer++;
                interval[1] = e;
            } else if (s >= interval[0] && e >= interval[1]) {
                interval[0] = s;
            }
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.46ms, 77.5MB)
// 테스트 2 〉	통과 (0.79ms, 73.2MB)
// 테스트 3 〉	통과 (0.90ms, 78.4MB)
// 테스트 4 〉	통과 (1.96ms, 80.4MB)
// 테스트 5 〉	통과 (11.70ms, 90.9MB)
// 테스트 6 〉	통과 (94.84ms, 121MB)
// 테스트 7 〉	통과 (427.85ms, 176MB)
// 테스트 8 〉	통과 (389.54ms, 180MB)
// 테스트 9 〉	통과 (24.20ms, 175MB)
// 테스트 10 〉	통과 (429.20ms, 169MB)
// 테스트 11 〉	통과 (0.47ms, 79.4MB)
