import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int type : tangerine) {
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> map.get(o2) - map.get(o1));
        
        for (Integer key : keyList) {
            k -= map.get(key);
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}
