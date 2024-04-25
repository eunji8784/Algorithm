import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String history = st.nextToken();
            int now = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
            
            map.put(carNum, map.getOrDefault(carNum, 0) + (history.equals("IN") ? -now : now));
        }
        
        int[] answer = new int[map.keySet().size()];
        int idx = 0;
        
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value <= 0) {
                map.put(key, value + 1439);
            }
            
            value = map.get(key);
            if (value <= fees[0]) {
                answer[idx++] = fees[1]; 
            } else {
                answer[idx++] = fees[1] + (int)Math.ceil((double)(value - fees[0]) / fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}
