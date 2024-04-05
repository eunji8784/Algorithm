import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        char prevChar = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (set.contains(word) || word.charAt(0) != prevChar) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                prevChar = word.charAt(word.length() - 1);
                set.add(word);
            }
        }

        return answer;
    }
}
