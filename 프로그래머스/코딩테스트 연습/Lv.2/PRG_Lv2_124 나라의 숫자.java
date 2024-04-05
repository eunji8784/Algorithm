class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        final String[] DIGIT = {"4", "1", "2"};
        
        while (n > 0) {
            int index = n % 3;
            n /= 3;
            sb.insert(0, DIGIT[index]);
            if (index == 0) {
                n--;
            }
        }
        
        return sb.toString();
    }
}
