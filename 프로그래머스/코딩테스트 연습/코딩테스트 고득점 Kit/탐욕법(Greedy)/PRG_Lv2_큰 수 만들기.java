class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int n = len - k;
        int start = 0;
        
        while (n > 0) {
            int i = start;
            int max = -1;
            while (len - i >= n) {
                if (number.charAt(i) > max) {
                    max = number.charAt(i);
                    start = i;
                }
                i++;
            }
            answer.append(number.charAt(start++));
            n--;
        }
        
        return answer.toString();
    }
}

// 테스트 1 〉	통과 (0.11ms, 71.7MB)
// 테스트 2 〉	통과 (0.03ms, 75.2MB)
// 테스트 3 〉	통과 (0.06ms, 76.9MB)
// 테스트 4 〉	통과 (0.15ms, 73.7MB)
// 테스트 5 〉	통과 (0.48ms, 74MB)
// 테스트 6 〉	통과 (15.47ms, 77.1MB)
// 테스트 7 〉	통과 (37.08ms, 86.5MB)
// 테스트 8 〉	통과 (265.28ms, 87.1MB)
// 테스트 9 〉	통과 (24.94ms, 97.4MB)
// 테스트 10 〉	통과 (9306.86ms, 81.7MB)
// 테스트 11 〉	통과 (0.04ms, 75.1MB)
// 테스트 12 〉	통과 (0.05ms, 78.1MB)
