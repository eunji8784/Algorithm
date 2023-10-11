import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> lst = new ArrayList<>();
        for (int num : numbers) lst.add(String.valueOf(num));
        
        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            } 
        });
        
        if(lst.get(0).equals("0")) return "0";
        
        StringBuilder answer = new StringBuilder();
        for (String str : lst) answer.append(str);
        
        return answer.toString();
    }
}

// 테스트 1 〉	통과 (155.42ms, 116MB)
// 테스트 2 〉	통과 (111.64ms, 112MB)
// 테스트 3 〉	통과 (207.47ms, 131MB)
// 테스트 4 〉	통과 (9.60ms, 80.7MB)
// 테스트 5 〉	통과 (170.33ms, 117MB)
// 테스트 6 〉	통과 (113.09ms, 101MB)
// 테스트 7 〉	통과 (1.85ms, 77.6MB)
// 테스트 8 〉	통과 (2.22ms, 70.3MB)
// 테스트 9 〉	통과 (1.92ms, 82.8MB)
// 테스트 10 〉	통과 (1.77ms, 71.1MB)
// 테스트 11 〉	통과 (1.88ms, 80.8MB)
// 테스트 12 〉	통과 (1.92ms, 77.5MB)
// 테스트 13 〉	통과 (2.25ms, 90.5MB)
// 테스트 14 〉	통과 (2.58ms, 80.1MB)
// 테스트 15 〉	통과 (1.82ms, 68.6MB)
