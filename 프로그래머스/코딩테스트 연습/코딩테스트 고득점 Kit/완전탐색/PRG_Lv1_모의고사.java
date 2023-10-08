import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int len1 = arr1.length, len2 = arr2.length, len3 = arr3.length;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[i % len1]) cnt1++;
            if (answers[i] == arr2[i % len2]) cnt2++;
            if (answers[i] == arr3[i % len3]) cnt3++;
        } 
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        if (cnt1 == max) list.add(1);
        if (cnt2 == max) list.add(2);
        if (cnt3 == max) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }
}

// 테스트 1 〉	통과 (1.87ms, 70.1MB)
// 테스트 2 〉	통과 (2.21ms, 82MB)
// 테스트 3 〉	통과 (1.88ms, 76.2MB)
// 테스트 4 〉	통과 (2.71ms, 77.1MB)
// 테스트 5 〉	통과 (2.03ms, 76.9MB)
// 테스트 6 〉	통과 (1.80ms, 76.4MB)
// 테스트 7 〉	통과 (2.10ms, 78.8MB)
// 테스트 8 〉	통과 (2.00ms, 85.1MB)
// 테스트 9 〉	통과 (2.47ms, 78MB)
// 테스트 10 〉	통과 (2.23ms, 78.6MB)
// 테스트 11 〉	통과 (2.57ms, 82.5MB)
// 테스트 12 〉	통과 (2.50ms, 79.6MB)
// 테스트 13 〉	통과 (2.32ms, 74.3MB)
// 테스트 14 〉	통과 (2.75ms, 75.8MB)
