import java.util.*;

class Solution {
    private static String[] user_id, banned_id;
    private static HashSet<HashSet<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        comb(0, new HashSet<>());
        
        return result.size();
    }
    
    private void comb(int count, HashSet<String> set) {
        if (count == banned_id.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!set.contains(user_id[i]) && isMatch(user_id[i], banned_id[count])) {
                set.add(user_id[i]);
                comb(count + 1, new HashSet<>(set));
                set.remove(user_id[i]);
            }
        }
        
    }

    private boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    
}

// 테스트 1 〉	통과 (0.06ms, 73.5MB)
// 테스트 2 〉	통과 (0.25ms, 76.5MB)
// 테스트 3 〉	통과 (0.40ms, 78.2MB)
// 테스트 4 〉	통과 (0.17ms, 73.2MB)
// 테스트 5 〉	통과 (84.15ms, 116MB)
// 테스트 6 〉	통과 (4.81ms, 67.5MB)
// 테스트 7 〉	통과 (0.11ms, 72.5MB)
// 테스트 8 〉	통과 (0.13ms, 75.9MB)
// 테스트 9 〉	통과 (0.15ms, 71.6MB)
// 테스트 10 〉	통과 (0.08ms, 74.6MB)
// 테스트 11 〉	통과 (0.34ms, 73.7MB)
