import java.util.*;

class Solution {
    private static int answer;
    private static String target;
    private static String[] words;
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        final int INF = 51;
        answer = INF;      
        boolean[] check = new boolean[words.length];
        dfs(begin, 0, check);       
        return answer == INF ? 0 : answer;
    }
    
    private static void dfs(String word, int count, boolean[] check) {
        if (count >= answer) return;
        
        if (word.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (check[i]) continue;
            int diff = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) != word.charAt(j)) diff++;
                if (diff > 1) break;
            }
            if (diff == 1) {
                check[i] = true;
                dfs(words[i], count + 1, check);
                check[i] = false;
            }
        }
    }
}

// 테스트 1 〉	통과 (0.05ms, 70.4MB)
// 테스트 2 〉	통과 (0.07ms, 63.8MB)
// 테스트 3 〉	통과 (0.16ms, 75.5MB)
// 테스트 4 〉	통과 (0.04ms, 70.6MB)
// 테스트 5 〉	통과 (0.03ms, 73MB)
