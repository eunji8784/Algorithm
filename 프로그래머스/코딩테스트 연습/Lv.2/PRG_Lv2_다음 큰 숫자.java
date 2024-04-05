class Solution {
    public int solution(int n) {
        int count = getCount(n);
        
        while (true) {
            if (getCount(++n) == count) break;
        }
        
        return n;
    }
    
    private static int getCount(int num) {
        int count = 0;
        
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }
        
        return count;
    }
}
