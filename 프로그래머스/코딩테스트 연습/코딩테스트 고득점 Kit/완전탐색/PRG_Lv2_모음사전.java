import java.io.*;
import java.util.*;

class Solution {
    private static final char[] ALPHABET = {'A', 'E', 'I', 'O', 'U'};
    private static final int N = 5;
    
    private static char[] selected;
    private static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        for (int i = 1; i <= N; i++) {
            selected = new char[i];
            solve(0, i, selected);
        }
        
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    private static void solve(int depth, int length, char[] selected) {
        if (depth == length) {
            list.add(new String(selected));
            return;
        }
        
        for (int i = 0; i < N; i++) {
            selected[depth] = ALPHABET[i];
            solve(depth + 1, length, selected);
        }
    }
}

// 테스트 1 〉	통과 (2.61ms, 74.2MB)
// 테스트 2 〉	통과 (3.53ms, 80.1MB)
// 테스트 3 〉	통과 (2.67ms, 74.3MB)
// 테스트 4 〉	통과 (3.70ms, 79.7MB)
// 테스트 5 〉	통과 (2.87ms, 74.5MB)
// 테스트 6 〉	통과 (2.51ms, 73.8MB)
// 테스트 7 〉	통과 (2.81ms, 77.6MB)
// 테스트 8 〉	통과 (2.37ms, 71.7MB)
// 테스트 9 〉	통과 (2.99ms, 83.6MB)
// 테스트 10 〉	통과 (2.33ms, 80.7MB)
// 테스트 11 〉	통과 (2.50ms, 77.9MB)
// 테스트 12 〉	통과 (2.46ms, 72.9MB)
// 테스트 13 〉	통과 (2.76ms, 74.3MB)
// 테스트 14 〉	통과 (2.91ms, 73.4MB)
// 테스트 15 〉	통과 (2.70ms, 77.7MB)
// 테스트 16 〉	통과 (2.29ms, 75.9MB)
// 테스트 17 〉	통과 (2.70ms, 72.1MB)
// 테스트 18 〉	통과 (2.91ms, 77MB)
// 테스트 19 〉	통과 (3.04ms, 73.1MB)
// 테스트 20 〉	통과 (3.27ms, 73.7MB)
// 테스트 21 〉	통과 (2.65ms, 79.9MB)
// 테스트 22 〉	통과 (2.29ms, 75MB)
// 테스트 23 〉	통과 (2.39ms, 84.9MB)
// 테스트 24 〉	통과 (3.27ms, 76.1MB)
// 테스트 25 〉	통과 (2.46ms, 74.4MB)
// 테스트 26 〉	통과 (3.63ms, 74.2MB)
// 테스트 27 〉	통과 (2.89ms, 70.1MB)
// 테스트 28 〉	통과 (2.68ms, 82.4MB)
// 테스트 29 〉	통과 (2.42ms, 77.3MB)
// 테스트 30 〉	통과 (2.37ms, 76.9MB)
// 테스트 31 〉	통과 (2.88ms, 75.7MB)
// 테스트 32 〉	통과 (3.38ms, 73MB)
// 테스트 33 〉	통과 (2.90ms, 76.1MB)
// 테스트 34 〉	통과 (3.08ms, 73.1MB)
// 테스트 35 〉	통과 (2.32ms, 77.6MB)
// 테스트 36 〉	통과 (3.60ms, 71.7MB)
// 테스트 37 〉	통과 (3.64ms, 73.7MB)
// 테스트 38 〉	통과 (2.64ms, 76.6MB)
// 테스트 39 〉	통과 (2.48ms, 78.1MB)
// 테스트 40 〉	통과 (3.56ms, 71.9MB)
